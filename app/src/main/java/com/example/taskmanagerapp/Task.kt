package com.example.taskmanagerapp
data class Task(
    var id: Long = -1,
    var title: String,
    var description: String,
    var dueDate: String,
    var priority: String,
    var category: String,
    var status: String
)
