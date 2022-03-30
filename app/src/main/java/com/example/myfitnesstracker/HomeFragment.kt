package com.example.myfitnesstracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogin = view.findViewById<Button>(R.id.btnLogin)
        val btnSignUp = view.findViewById<Button>(R.id.btnSignUp)

        btnLogin.setOnClickListener {
            val loginDialog = LoginDialog()
            loginDialog.show(parentFragmentManager, "Login Window")
        }

        btnSignUp.setOnClickListener {
            val signUpDialog = SignUpDialog()
            signUpDialog.show(parentFragmentManager, "Sign Up")
        }
    }
}