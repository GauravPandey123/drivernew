package com.augrocerrydelivery.audeliveryapp

import android.app.Application
import com.augrocerrydelivery.audeliveryapp.session.SessionManager

//global variables can be accessed across application context
val sessionManager: SessionManager by lazy {
    BaseApplication.sessionManager!!
}



class BaseApplication : Application(){

    companion object {
        var sessionManager: SessionManager? = null
    }
    override fun onCreate() {
        super.onCreate()
        initialization()
    }

    private fun initialization() {
        sessionManager = SessionManager(applicationContext)
    }


}