package com.example.myfitnesstracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class ExerciseFragment : Fragment(R.layout.fragment_exercise) {

    @SuppressLint("NewApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvHome = view.findViewById<TextView>(R.id.tvHome)

        val curDate = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy")
        val formatDate = curDate.format(formatter)

        tvHome.text = "Choose your Exercises for ${formatDate}"

        val exerciseList = listOf<String>(
            "Bicep Curls",
            "Bench Press",
            "Tricep Pulldown"
        )

        val areaList = listOf<Int>(
            R.drawable.bicep_workout,
            R.drawable.bench_press_workout,
            R.drawable.tricep_pulldown_workout
        )

        val workoutList = listOf<Int>(
            R.drawable.bicep_area,
            R.drawable.bench_press_area,
            R.drawable.tricep_pulldown_area
        )

        val rvExercises = view.findViewById<RecyclerView>(R.id.rvExercises)

        val adapter = ExerciseItemAdapter(exerciseList, areaList, workoutList, (activity as MainActivity))
        rvExercises.layoutManager = LinearLayoutManager(activity as MainActivity)
        rvExercises.adapter = adapter
    }
}