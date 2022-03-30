package com.example.myfitnesstracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class SignUpDialog(): DialogFragment(R.layout.dialog_signup) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnNewCancel = view.findViewById<Button>(R.id.btnNewCancel)
        val btnNewSignUp = view.findViewById<Button>(R.id.btnNewSignUp)
        val etNewEmail = view.findViewById<EditText>(R.id.etNewEmail)
        val etNewUserName = view.findViewById<EditText>(R.id.etNewUserName)
        val etNewPassword = view.findViewById<EditText>(R.id.etNewPassword)

        val homeLoggedInFragment = HomeLoggedInFragment()

        btnNewSignUp.setOnClickListener {
            if(etNewEmail.text.isEmpty() || etNewUserName.text.isEmpty() || etNewPassword.text.isEmpty()){
                Toast.makeText(activity as MainActivity, "Must input your email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            parentFragmentManager.beginTransaction().apply {
                dismiss()
                replace(R.id.flFragment, homeLoggedInFragment)
                commit()
                (activity as MainActivity).SetLoggedInToTrue()
                (activity as MainActivity).SetUserName(etNewUserName.text.toString())
                Toast.makeText(activity as MainActivity, "Welcome ${etNewUserName.text.toString()}", Toast.LENGTH_SHORT).show()
            }
        }

        btnNewCancel?.setOnClickListener {
            dismiss()
        }

    }
}