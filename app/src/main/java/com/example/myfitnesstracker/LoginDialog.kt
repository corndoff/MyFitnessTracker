package com.example.myfitnesstracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class LoginDialog(): DialogFragment(R.layout.dialog_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSignIn = view.findViewById<Button>(R.id.btnLog)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)
        val etEmail = view.findViewById<EditText>(R.id.etSets)
        val etPassword = view.findViewById<EditText>(R.id.etReps)
        val homeLoggedInFragment = HomeLoggedInFragment()

        btnSignIn.setOnClickListener {
            if(etEmail.text.isEmpty() || etPassword.text.isEmpty()){
                Toast.makeText(activity as MainActivity, "Must input your email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            parentFragmentManager.beginTransaction().apply {
                dismiss()
                replace(R.id.flFragment, homeLoggedInFragment)
                commit()
                (activity as MainActivity).SetLoggedInToTrue()
                (activity as MainActivity).SetUserName(etEmail.text.toString())
                Toast.makeText(activity as MainActivity, "Welcome back ${etEmail.text.toString()}", Toast.LENGTH_SHORT).show()
            }


        }

        btnCancel?.setOnClickListener {
            dismiss()
        }

    }
}