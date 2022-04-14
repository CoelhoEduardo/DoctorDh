package com.example.doctordh.loginscreen

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import com.example.doctordh.R
import com.example.doctordh.viewmodel.LoginViewModel
import com.google.android.material.textfield.TextInputLayout

class LoginScreen : Fragment(R.layout.fragment_login_screen) {

    private val viewModel: LoginViewModel by viewModels()

    private val emailInput: TextInputLayout?
        get() = view?.findViewById(R.id.login_input)

    private val passInput: TextInputLayout?
        get() = view?.findViewById(R.id.pass_input)

    private val loginbtn: Button?
        get() = view?.findViewById(R.id.login_button)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.login("usuario@dhdoctor.com.br","123456")
        loginObserve()

        loginbtn?.setOnClickListener{
            sendToProfile()
        }

        val dialog = ForgotPasswordDialogFragment()
        val forgetpass = view.findViewById<Button>(R.id.forgotpass_button)
        forgetpass.setOnClickListener {
            dialog.show(parentFragmentManager, ForgotPasswordDialogFragment.TAG)
        }
    }

    fun loginObserve(){
        viewModel.error.observe(viewLifecycleOwner){
            if (it)
                println("DEU RUIM!!!!!!!!!")

        }
        viewModel.sucess.observe(viewLifecycleOwner){
            println("Deu Bom")
        }



    }

    private fun sendToProfile() {
        findNavController().navigate(R.id.action_loginScreen_to_profileScreen)
    }
}
