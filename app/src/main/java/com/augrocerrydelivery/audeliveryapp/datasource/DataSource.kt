package com.augrocerrydelivery.audeliveryapp.datasource

import com.augrocerry.android.networkservice.RetrofitService
import com.augrocerrydelivery.audeliveryapp.model.login.LoginRequest
import com.augrocerrydelivery.audeliveryapp.model.login.response.LoginResponse
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

suspend fun <T : Any> Call<T>.getResult(): Result<T> = suspendCoroutine {
    this.enqueue(object : Callback<T> {

        override fun onFailure(call: Call<T>?, error: Throwable?) =
                it.resume(Result.Error(error))

        override fun onResponse(call: Call<T>?, response: Response<T>?) {
            if (response?.body() != null) {
                it.resume(Result.Success(response.body()!!))
            } else {
                it.resume(Result.Error(Throwable("INTERNAL SERVER ERROR")))
            }
        }
    })
}

inline fun <T : Any> Result<T>.onSuccess(action: (T) -> Unit): Result<T> {
    if (this is Result.Success) action(data)

    return this
}

inline fun <T : Any> Result<T>.onError(action: (Throwable) -> Unit) {
    if (this is Result.Error && error != null) action(error)
}

suspend fun loginUser(loginRequest: LoginRequest): Result<LoginResponse> = GlobalScope.async {
    //apiService
    return@async RetrofitService().neargroupTest.driverLogin(loginRequest).getResult()
}.await()