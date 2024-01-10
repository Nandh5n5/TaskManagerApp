package com.example.taskmanagerapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(
    private var tasks: List<Task>,
    private val onCompleteTask: (Long) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTitle: TextView = itemView.findViewById(R.id.textViewTitle)
        private val textViewDescription: TextView = itemView.findViewById(R.id.textViewDescription)
        private val textViewDueDate: TextView = itemView.findViewById(R.id.textViewDueDate)
        private val textViewPriority: TextView = itemView.findViewById(R.id.textViewPriority)
        private val textViewCategory: TextView = itemView.findViewById(R.id.textViewCategory)
        private val textViewStatus: TextView = itemView.findViewById(R.id.textViewStatus)
        private val buttonComplete: Button = itemView.findViewById(R.id.buttonComplete)

        fun bind(task: Task) {
            textViewTitle.text = task.title
            textViewDescription.text = task.description
            textViewDueDate.text = task.dueDate
            textViewPriority.text = task.priority
            textViewCategory.text = task.category
            textViewStatus.text = task.status

            buttonComplete.setOnClickListener {
                onCompleteTask(task.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    // Function to update the dataset and refresh the RecyclerView
    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}
