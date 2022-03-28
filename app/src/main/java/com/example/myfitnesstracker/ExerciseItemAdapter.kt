package com.example.myfitnesstracker

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_exercise_item.*
import kotlinx.android.synthetic.main.fragment_exercise_item.view.*

class ExerciseItemAdapter(
    var exerciseList: List<String>,
    val lookList: List<Int>, // We need to pass the drawable ids in this list
    val areaList: List<Int>,
    val context: Context
): RecyclerView.Adapter<ExerciseItemAdapter.ExerciseItemHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ExerciseItemAdapter.ExerciseItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_exercise_item, parent, false)
        return ExerciseItemHolder(view)
    }

    override fun onBindViewHolder(holder: ExerciseItemAdapter.ExerciseItemHolder, position: Int) {
        val curExerciseItem = exerciseList[position]
        val curLookItem = lookList[position]
        val curAreaItem = areaList[position]
        holder.itemView.tvSingleExercise.text = curExerciseItem

        holder.itemView.ivExerciseLook.setImageDrawable(ContextCompat.getDrawable(context, curLookItem))

        holder.itemView.tvSingleExercise.setOnClickListener {
            // Create a dialog then have it pop up with sets and reps to input then save and cancel buttons
        }
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    inner class ExerciseItemHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}