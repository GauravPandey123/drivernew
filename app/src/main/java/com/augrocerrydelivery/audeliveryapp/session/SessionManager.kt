package com.augrocerrydelivery.audeliveryapp.session

import android.content.Context
import android.content.SharedPreferences
import com.augrocerrydelivery.audeliveryapp.model.login.response.LoginResponse


import com.google.gson.Gson
import com.google.gson.JsonParseException
import com.google.gson.JsonSyntaxException

class SessionManager(context: Context) {
    companion object {
        private const val USER_PREF = "user_pref"
        private const val USER_TOKEN = "user_token"
        private const val USER_DATA = "user_data"
        private const val FCM_TOKEN = "fcm_token"
        private const val SIGNIN_DATA="signin_data"
        private const val FCM_TOKEN_DATA="FCM_TOKEN_DATA"
    }


//    //save user signUpData
//    fun saveUserSignUpData(context: Context?, signUpResponse: SignUpResponse) {
//        val gson = Gson()
//        context?.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)?.edit()
//            ?.putString(USER_DATA, gson.toJson(signUpResponse))?.apply()
//    }
//
//    //get user data
//    fun getUserData(context: Context?): SignUpResponse? {
//        val gson = Gson()
//        return try {
//            gson.fromJson<SignUpResponse>(
//                context?.getSharedPreferences(
//                    USER_PREF,
//                    Context.MODE_PRIVATE
//                )?.getString(USER_DATA, null), SignUpResponse::class.java
//            )
//        } catch (e: JsonSyntaxException) {
//            null
//        }
//    }

    

    fun clearlocalData(context: Context)
    {
        context.getSharedPreferences(USER_PREF,Context.MODE_PRIVATE).edit().clear().apply()
    }

    var fcmToken:String?
        get() = pref.getString(FCM_TOKEN,null)
        set(value) = pref.edit().putString(FCM_TOKEN,value).apply()

    fun clearUserData(context: Context?) {
        context?.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)?.edit()?.clear()?.apply()
    }

    private val pref: SharedPreferences =
        context.getSharedPreferences(USER_PREF, Context.MODE_PRIVATE)




    var userData: LoginResponse?
        get() = try {
            Gson().fromJson(pref.getString(USER_DATA, null), LoginResponse::class.java)
        } catch (e: JsonParseException) {
            null
        } catch (e: JsonSyntaxException) {
            null
        }
        set(value) = pref.edit().putString(USER_DATA, Gson().toJson(value)).apply()








}