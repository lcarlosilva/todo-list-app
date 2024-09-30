package com.luiz.todo_list_app.data

import com.luiz.todo_list_app.domain.Todo
import kotlinx.coroutines.flow.Flow

interface TodoRepository {
    suspend fun insert(title: String, description: String?)

    suspend fun updateCompleted(id: Long, isCompleted: Boolean)

    suspend fun delete(id: Long)

    fun getAllTodos(): Flow<List<Todo>>

    suspend fun getTodoBy(id: Long): Todo?
}