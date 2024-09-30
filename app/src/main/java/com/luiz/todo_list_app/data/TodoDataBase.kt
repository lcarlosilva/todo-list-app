package com.luiz.todo_list_app.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [TodoEntity::class],
    version = 1,
)
abstract class TodoDataBase : RoomDatabase() {
    abstract val todoDao: TodoDao
}

