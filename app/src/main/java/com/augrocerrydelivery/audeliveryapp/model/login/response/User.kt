package com.augrocerrydelivery.audeliveryapp.model.login.response

import com.google.gson.annotations.SerializedName

data class User(

	@field:SerializedName("phone_no")
	val phoneNo: String? = null,

	@field:SerializedName("driver_id")
	val driverId: String? = null,

	@field:SerializedName("loginType")
	val loginType: String? = null,

	@field:SerializedName("created")
	val created: String? = null,

	@field:SerializedName("latitude")
	val latitude: String? = null,

	@field:SerializedName("last_name")
	val lastName: String? = null,

	@field:SerializedName("otp")
	val otp: String? = null,

	@field:SerializedName("language")
	val language: String? = null,

	@field:SerializedName("accessToken")
	val accessToken: String? = null,

	@field:SerializedName("profile_pics")
	val profilePics: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("first_name")
	val firstName: String? = null,

	@field:SerializedName("fcmToken")
	val fcmToken: String? = null,

	@field:SerializedName("updated")
	val updated: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("longitude")
	val longitude: String? = null
)