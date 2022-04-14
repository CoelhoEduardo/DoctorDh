package com.example.doctordh.loginscreen

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.doctordh.R
import com.example.doctordh.Util.extension.load
import com.example.doctordh.viewmodel.ProfileViewModel
import com.google.android.material.textfield.TextInputEditText

class ProfileScreen : Fragment(R.layout.fragment_profile_screen) {


    private val viewModel: ProfileViewModel? by viewModels()
    private val loading: FrameLayout?
        get() = view?.findViewById(R.id.loading)
    private val phone: TextInputEditText?
        get() = view?.findViewById(R.id.phone)
    private val name: TextInputEditText?
        get() = view?.findViewById(R.id.name_input)
    private val bday: TextInputEditText?
        get() = view?.findViewById(R.id.birthday)
    private val location: TextInputEditText?
        get() = view?.findViewById(R.id.location)
    private val profilePicture: ImageView?
        get() = view?.findViewById(R.id.profilephoto)
    private val continue_btn: Button?
        get() = view?.findViewById(R.id.continue_button)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel?.loadProfile()
        observeData()

        continue_btn?.setOnClickListener {
            sendToDoctor()
        }
    }

    fun observeData() {
        viewModel?.loading?.observe(viewLifecycleOwner) { loading?.isVisible = it }
        viewModel?.error?.observe(viewLifecycleOwner) {
            if (it)
                println("Deu erro")
        }
        viewModel?.profile?.observe(viewLifecycleOwner) {
            phone?.setText(it.phone)
            name?.setText(it.name.first)
            bday?.setText(it.registered.date)
            location?.setText(it.location.city)
            profilePicture?.load(it.picture.thumbnail)
        }
    }

    private fun sendToDoctor(){
        findNavController().navigate(R.id.action_profileScreen_to_doctorScreen)
    }


}
