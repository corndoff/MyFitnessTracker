package com.example.myfitnesstracker

import android.content.Context
import android.graphics.drawable.Drawable
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_exercise_item.*
import kotlinx.android.synthetic.main.fragment_exercise_item.view.*

class ExerciseItemAdapter(
    var exerciseList: List<String>,
    private val lookList: List<Int>,
    private val areaList: List<Int>,
    val context: Context,
    private val parentFragmentManager: FragmentManager
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

        holder.itemView.ivExerciseArea.setImageDrawable(ContextCompat.getDrawable(context, curAreaItem))

        holder.itemView.tvSingleExercise.setOnClickListener {
            val weightDialog = WeightsDialog()
            weightDialog.show(parentFragmentManager, "Exercise Log")
        }
    }

    override fun getItemCount(): Int {
        return exerciseList.size
    }

    inner class ExerciseItemHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}