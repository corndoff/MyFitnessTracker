package com.example.myfitnesstracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class LogoutDialog(): DialogFragment(R.layout.dialog_logout) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)
        val homeFragment = HomeFragment()

        btnLogout.setOnClickListener {
            parentFragmentManager.beginTransaction().apply {
                dismiss()
                replace(R.id.flFragment, homeFragment)
                commit()
                (activity as MainActivity).SetLoggedInToFalse()
                (activity as MainActivity).ClearUserName()
                Toast.makeText(activity as MainActivity, "You've been logged out", Toast.LENGTH_SHORT).show()
            }
        }

        btnCancel?.setOnClickListener {
            dismiss()
        }

    }
}