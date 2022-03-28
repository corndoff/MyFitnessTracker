package com.example.myfitnesstracker

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val frag = findViewById<FrameLayout>(R.id.flFragment)
        val homeFragment = HomeFragment()
        val exerciseFragment = ExerciseFragment()
        val workoutFragment = WorkoutFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(frag.id, homeFragment)
            commit()
        }






        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.miHome -> supportFragmentManager.beginTransaction().apply {
                    replace(frag.id, homeFragment)
                    commit()
                }

                R.id.miExercises -> supportFragmentManager.beginTransaction().apply {
                    replace(frag.id, exerciseFragment)
                    commit()
                }

                R.id.miWorkouts -> supportFragmentManager.beginTransaction().apply {
                    replace(frag.id, workoutFragment)
                    commit()
                }
            }
            true
        }
    }
}