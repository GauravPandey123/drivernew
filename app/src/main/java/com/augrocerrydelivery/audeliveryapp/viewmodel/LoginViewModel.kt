package com.augrocerrydelivery.audeliveryapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.augrocerrydelivery.audeliveryapp.model.login.LoginRequest
import com.augrocerrydelivery.audeliveryapp.networkservice.ApiResponse
import com.augrocerrydelivery.audeliveryapp.repository.LoginRepository

class LoginViewModel : ViewModel() {

    private val loginRepository: LoginRepository by lazy {
        LoginRepository()
    }

    fun loginById(loginRequest: LoginRequest): MutableLiveData<ApiResponse> {
        return loginRepository.loginData(loginRequest)
    }
}