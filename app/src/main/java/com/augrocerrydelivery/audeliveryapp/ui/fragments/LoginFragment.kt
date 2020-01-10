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
import com.augrocerrydelivery.audeliveryapp.ui.utils.isOnline
import com.augrocerrydelivery.audeliveryapp.ui.utils.showSnackbar
import com.augrocerrydelivery.audeliveryapp.viewmodel.LoginViewModel
import com.google.android.material.snackbar.Snackbar

import kotlinx.android.synthetic.main.login_fragment.*
import java.util.*

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
        setUpListeners()
        //  setUpObservers()
    }

    private fun setUpListeners() {
        textViewLogin.setOnClickListener {
            context?.isOnline()?.let {
                if (it) {
                    submitForn()
                } else {
                    nestedScrollViewLogin.showSnackbar(
                            resources.getString(R.string.pleasecheckinternet),
                            Snackbar.LENGTH_SHORT
                    )
                }
            }
        }
    }

    private fun setUpObservers(phoneNo: String, image: String, driverId: String, password: String, lattiude: String, logitude: String, fcmToken: String, language: String) {
        val request = LoginRequest(phoneNo, image, driverId, password, lattiude, logitude, fcmToken, language)
        contatinProgresBarLogin.visibility = View.VISIBLE

        loginViewModel.loginById(request).observe(this, Observer {
            if (it.response != null) {
                val response = it.response as LoginResponse
                if (response.success) {
                    contatinProgresBarLogin.visibility = View.GONE
                    nestedScrollViewLogin.showSnackbar(response.message.toString(), Snackbar.LENGTH_SHORT)
                } else {
                    contatinProgresBarLogin.visibility = View.GONE
                    nestedScrollViewLogin.showSnackbar(response.message.toString(), Snackbar.LENGTH_SHORT)

                }

            }

        })
    }

    private fun submitForn() {
//        if (!validatephone()) {
//            return
//        }
//
//        if (!validatePassword()) {
//            return
//        }
//
//        if (validateDriverId()) {
//            return
//        }
        mobieNo = editTestEmloyeeId.text.toString()
        driverId = editTextMobileNo.text.toString()
        password = editTextPassowrd.text.toString()
        setUpObservers("9891088434", "", "#DI001", "12345", "28.6623", " 77.1411", "123456", Locale.getDefault().language)

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
    }


}