package com.example.myfitnesstracker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class WeightsDialog(): DialogFragment(R.layout.dialog_weight_reps_sets) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnLog = view.findViewById<Button>(R.id.btnLog)
        val btnCancel = view.findViewById<Button>(R.id.btnCancel)
        val etSets = view.findViewById<EditText>(R.id.etSets)
        val etReps = view.findViewById<EditText>(R.id.etReps)
        val loggedIn = (activity as MainActivity).IsLoggedIn()

        btnLog.setOnClickListener {
            if(etSets.text.isEmpty() || etReps.text.isEmpty()){
                Toast.makeText(activity as MainActivity, "Must input your sets and reps", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(!loggedIn){
                Toast.makeText(activity as MainActivity, "Must be logged in to record exercise", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            parentFragmentManager.beginTransaction().apply {
                dismiss()
                // create db that creates new tables for each user that signs up.
                // Then make sure the user table stores the username, exercise, reps, sets, and date
                Toast.makeText(activity as MainActivity, "Exercise logged", Toast.LENGTH_SHORT).show()
            }


        }

        btnCancel?.setOnClickListener {
            dismiss()
        }

    }
}