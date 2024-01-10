package com.example.taskmanagerapp.db

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskmanagerapp.db.TaskDatabase
import kotlinx.android.synthetic.main.activity_main.*  // Make sure this import is correct

class MainActivity : AppCompatActivity() {

    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize RecyclerView and Adapter
        recyclerViewTasks.layoutManager = LinearLayoutManager(this)
        taskAdapter = TaskAdapter(emptyList()) { taskId ->
            // Handle task completion here
            // You can call updateTaskStatus or perform any other action
            // based on the task completion
        }
        recyclerViewTasks.adapter = taskAdapter

        // Load tasks from the database
        getAllTasks()

        // Example: Update a task status (replace with actual logic)
        updateTaskStatus(1, "Completed")
    }

    private fun getAllTasks() {
        val tasks = TaskDatabase.getInstance(this).taskDao().getAllTasks()
        taskAdapter.updateTasks(tasks)
    }

    private fun updateTaskStatus(taskId: Long, newStatus: String) {
        // Replace with your logic to update the task status in the database
        TaskDatabase.getInstance(this).taskDao().updateTaskStatus(taskId, newStatus)
    }
}
