package com.example.myfitnesstracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class HomeLoggedInFragment : Fragment(R.layout.fragment_home_logged_in) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLogout = view.findViewById<Button>(R.id.btnLogout)
        val tvWelcome = view.findViewById<TextView>(R.id.tvWelcome)
        val homeFragment = HomeFragment()

        val userName = (activity as MainActivity).GetUserName()

        tvWelcome.text = "Hello ${userName}"

        btnLogout.setOnClickListener {
            //parentFragmentManager.beginTransaction().apply {
            //    replace(R.id.flFragment, homeFragment)
            //    commit()
            //}
            val logoutDialog = LogoutDialog()
            logoutDialog.show(parentFragmentManager, "Logout Window")
        }

    }
}