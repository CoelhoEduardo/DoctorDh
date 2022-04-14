package com.example.doctordh.loginscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.doctordh.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ResetPasswordDialogFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_reset_password_dialog, container, false)
    }

    companion object{
        const val TAG = "ResetPasswordDialog"
    }

}