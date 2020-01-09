package com.augrocerrydelivery.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import com.augrocerrydelivery.audeliveryapp.R
import com.augrocerrydelivery.audeliveryapp.model.login.LoginRequest
import com.augrocerrydelivery.audeliveryapp.model.login.response.LoginResponse
import com.augrocerrydelivery.audeliveryapp.viewmodel.LoginViewModel

import kotlinx.android.synthetic.main.login_fragment.*

class LoginFragment : Fragment(), NavController.OnDestinationChangedListener {

    private lateinit var mobieNo: String
    private lateinit var driverId: String
    private lateinit var password: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private val loginViewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this).get(LoginViewModel::class.java)

    }

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpElements()
        //  setUpObservers()
    }

    private fun setUpObservers(phoneNo: String, image: String, driverId: String, password: String, lattiude: String, logitude: String, fcmToken: String, language: String) {
        val request = LoginRequest(phoneNo, image, driverId, password, lattiude, logitude, fcmToken, language)
        loginViewModel.loginById(request).observe(this, Observer {
            if (it.response != null) {
                val response = it.response as LoginResponse


            }

        })
    }

    private fun submitForn() {
        if (!validatephone()) {
            return
        }

        if (!validatePassword()) {
            return
        }

        if (validateDriverId()) {
            return
        }
    }

    private fun validatephone(): Boolean {
        mobieNo = editTextMobileNo.text.toString().trim()
        if (mobieNo.isEmpty()) {
            textInputLayoutMobileNo.error = getString(R.string.error_mobile_no)
            requestFocus(textInputLayoutMobileNo)
        } else {
            textInputLayoutMobileNo.isErrorEnabled = false
        }
        return true
    }

    private fun validatePassword(): Boolean {
        if (editTextPassowrd.text.toString().trim().isEmpty()) {
            textInputLayoutPassword.error = getString(R.string.err_msg_password)
            requestFocus(textInputLayoutPassword)
            return false
        } else {
            textInputLayoutPassword.isErrorEnabled = false
        }

        return true
    }


    private fun validateDriverId(): Boolean {
        if (editTestEmloyeeId.text.toString().trim().isEmpty()) {
            textInputLayoutEmpId.error = getString(R.string.error_driver_id)
            requestFocus(textInputLayoutEmpId)
            return false
        } else {
            textInputLayoutEmpId.isErrorEnabled = false

        }
        return true

    }


    private fun requestFocus(view: View) {
        if (view.requestFocus()) {
            activity?.window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }


    private fun setUpElements() {
        textViewForgotPassword.setOnClickListener {
            navForgotPassowrd()
        }
    }

    private fun navForgotPassowrd() {
        findNavController().navigate(R.id.action_launcherFragment_to_forgotPasswordFragment)

    }

    override fun onDestinationChanged(
            controller: NavController,
            destination: NavDestination,
            arguments: Bundle?
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}