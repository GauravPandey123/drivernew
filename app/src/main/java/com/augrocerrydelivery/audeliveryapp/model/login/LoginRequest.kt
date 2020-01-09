package com.augrocerrydelivery.audeliveryapp.model.login

import com.google.gson.annotations.SerializedName

data class LoginRequest(

	@field:SerializedName("phone_no")
	val phoneNo: String? = null,

	@field:SerializedName("image")
	val image: String? = null,

	@field:SerializedName("driver_id")
	val driverId: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("login_type")
	val loginType: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("fcm_token")
	val fcmToken: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
)