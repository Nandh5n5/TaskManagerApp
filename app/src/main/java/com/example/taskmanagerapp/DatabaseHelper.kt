package com.example.taskmanagerapp
// DatabaseHelper.kt
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "task_manager.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_TASKS = "tasks"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_DESCRIPTION = "description"
        private const val COLUMN_DUE_DATE = "due_date"
        private const val COLUMN_PRIORITY = "priority"
        private const val COLUMN_CATEGORY = "category"
        private const val COLUMN_STATUS = "status"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = """
            CREATE TABLE $TABLE_TASKS (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_TITLE TEXT,
                $COLUMN_DESCRIPTION TEXT,
                $COLUMN_DUE_DATE TEXT,
                $COLUMN_PRIORITY TEXT,
                $COLUMN_CATEGORY TEXT,
                $COLUMN_STATUS TEXT
            )
        """.trimIndent()

        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // If you need to perform any database schema changes, do it here
    }

    // Add a new task to the database
    fun addTask(task: Task) {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE, task.title)
            put(COLUMN_DESCRIPTION, task.description)
            put(COLUMN_DUE_DATE, task.dueDate)
            put(COLUMN_PRIORITY, task.priority)
            put(COLUMN_CATEGORY, task.category)
            put(COLUMN_STATUS, task.status)
        }

        val newRowId = db.insert(TABLE_TASKS, null, values)
        db.close()
    }

    // ... (other methods)
}