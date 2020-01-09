package com.augrocerrydelivery.audeliveryapp.repository

import androidx.lifecycle.MutableLiveData
import com.augrocerrydelivery.audeliveryapp.BaseApplication
import com.augrocerrydelivery.audeliveryapp.datasource.loginUser
import com.augrocerrydelivery.audeliveryapp.datasource.onError
import com.augrocerrydelivery.audeliveryapp.datasource.onSuccess
import com.augrocerrydelivery.audeliveryapp.model.login.LoginRequest
import com.augrocerrydelivery.audeliveryapp.model.login.response.LoginResponse
import com.augrocerrydelivery.audeliveryapp.model.login.response.User
import com.augrocerrydelivery.audeliveryapp.networkservice.ApiResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginRepository {

    fun loginData(loginRequest: LoginRequest): MutableLiveData<ApiResponse> {
        val resultLiveData = MutableLiveData<ApiResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            val request = loginUser(loginRequest)
            request.onSuccess {
                withContext(Dispatchers.Main) {
                    if (it.success!! && it.user != null) {
                        saveUserData(it)
                    }

                }
                resultLiveData.postValue(ApiResponse(it, null))
            }
            request.onError {
                resultLiveData.postValue(ApiResponse(null, it))

            }

        }
        return resultLiveData
    }


    private fun saveUserData(loginResponse: LoginResponse) {
        val userDetail = User(loginResponse.user?.phoneNo
                , loginResponse.user?.driverId
                , loginResponse.user?.loginType, loginResponse.user?.created
                , loginResponse.user?.latitude, loginResponse.user?.lastName, loginResponse.user?.otp
                , loginResponse.user?.language, loginResponse.user?.accessToken, loginResponse.user?.profilePics
                , loginResponse.user?.password, loginResponse.user?.firstName, loginResponse.user?.fcmToken
                , loginResponse.user?.updated, loginResponse.user?.email, loginResponse.user?.longitude)
        val loginResponseData =
                LoginResponse(loginResponse.success, loginResponse.message, userDetail)
        BaseApplication.sessionManager?.userData = loginResponseData

    }
}