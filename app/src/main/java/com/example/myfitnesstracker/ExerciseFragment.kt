package com.example.myfitnesstracker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ExerciseFragment : Fragment(R.layout.fragment_exercise) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val exerciseList = listOf<String>(
            "Biking",
            "Home",
            "Lifting Weights"
        )

        val areaList = listOf<Int>(
            R.drawable.ic_exercises,
            R.drawable.ic_home,
            R.drawable.ic_workouts
        )

        val workoutList = listOf<Int>(
            1,
            2,
            3
        )

        val rvExercises = view.findViewById<RecyclerView>(R.id.rvExercises)

        val adapter = ExerciseItemAdapter(exerciseList, areaList, workoutList, (activity as MainActivity))
        rvExercises.layoutManager = LinearLayoutManager(activity as MainActivity)
        rvExercises.adapter = adapter
    }
}