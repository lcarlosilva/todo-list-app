package com.luiz.todo_list_app.data

import android.content.Context
import androidx.room.Room

object TodoDataBaseProvider {

    @Volatile
    private var INSTANCE: TodoDataBase? = null

    fun provide(context: Context): TodoDataBase {
        return INSTANCE ?: synchronized(this) {
            val instance = Room.databaseBuilder(
                context.applicationContext,
                TodoDataBase::class.java,
                "todo_app"
            ).build()
            INSTANCE = instance
            instance
        }
    }
}