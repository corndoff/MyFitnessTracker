package com.example.myfitnesstracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class LoginDialog(): DialogFragment(R.layout.dialog_login) { //AppCompatDialog(context) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnSignIn = view.findViewById<Button>(R.id.btnSignIn)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)
        val etEmail = view.findViewById<EditText>(R.id.etEmail)
        val etPassword = view.findViewById<EditText>(R.id.etPassword)
        val homeLoggedInFragment = HomeFragment()//Need to make a new home fragment for logged in people

        btnSignIn.setOnClickListener {
            if(etEmail.text.isEmpty() || etPassword.text.isEmpty()){
                Toast.makeText(activity as MainActivity, "Must input your email and password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            parentFragmentManager.beginTransaction().apply {
                dismiss()
                replace(R.id.flFragment, homeLoggedInFragment)
                commit()
                Toast.makeText(activity as MainActivity, "Welcome back ${etEmail.text.toString()}", Toast.LENGTH_SHORT).show()
            }


        }
        //btnPayNow?.setOnClickListener {
        //    cfPayNow.validate()
        //    if(cfPayNow.isValid()){
        //        dismiss()
        //        for (item in items) {
        //            val orderedItem = OrderedItems(tableNumber, item)
        //            viewModel.upsert(orderedItem)
        //        }
        //        (activity as MainActivity).clearList()
        //        parentFragmentManager.beginTransaction().apply {
        //            replace(R.id.fragment, startFragment)
        //            commit()
        //            Toast.makeText(activity as MainActivity, "Thank you! Your order will be out shortly", Toast.LENGTH_SHORT).show()
        //        }
        //    }
        // }

        btnCancel?.setOnClickListener {
            dismiss()
        }

    }
}