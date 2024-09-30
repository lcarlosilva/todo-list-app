package com.luiz.todo_list_app.data

import com.luiz.todo_list_app.domain.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TodoRepositoryImpl(
    private val dao: TodoDao
) : TodoRepository {
    override suspend fun insert(title: String, description: String?) {
        dao.insert(
            TodoEntity(
                title = title, description = description, isCompleted = false
            )
        )
    }

    override suspend fun updateCompleted(id: Long, isCompleted: Boolean) {
        val existingTodoEntity = getExistingTodoEntity(id) ?: return
        val updatedTodoEntity = existingTodoEntity.copy(isCompleted = isCompleted)
        dao.insert(updatedTodoEntity)

    }

    override suspend fun delete(id: Long) {
        val existingTodoEntity = getExistingTodoEntity(id) ?: return
        dao.delete(existingTodoEntity)
    }

    override fun getAllTodos(): Flow<List<Todo>> {
        return dao.getAllTodos().map { entities ->
            entities.map { entity ->
                createTodo(entity)
            }
        }
    }

    override suspend fun getTodoBy(id: Long): Todo? {
        return dao.getTodoBy(id)?.let { entity ->
            createTodo(entity)
        }
    }

    private suspend fun getExistingTodoEntity(id: Long) = dao.getTodoBy(id)

    private fun createTodo(entity: TodoEntity) = Todo(
        id = entity.id,
        title = entity.title,
        description = entity.description,
        isCompleted = entity.isCompleted
    )
}