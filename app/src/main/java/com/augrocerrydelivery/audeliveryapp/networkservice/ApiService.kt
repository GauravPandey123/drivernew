package com.augrocerrydelivery.audeliveryapp.networkservice

import com.augrocerrydelivery.audeliveryapp.model.login.LoginRequest
import com.augrocerrydelivery.audeliveryapp.model.login.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    @POST("driver-login.php")
    fun driverLogin(@Body loginRequest: LoginRequest) : Call<LoginResponse>


}