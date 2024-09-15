package com.luiz.todo_list_app.domain

data class Todo(
    val id: Long,
    val title: String,
    val description: String?,
    val isCompleted: Boolean
)

// fake objects
val todoOne = Todo(
    id = 1,
    title = "Todo 1",
    description = "Description 1",
    isCompleted = false
)

val todoTwo = Todo(
    id = 2,
    title = "Todo 2",
    description = "Description 2",
    isCompleted = true
)

val todoThree = Todo(
    id = 3,
    title = "Todo 3",
    description = "Description 3",
    isCompleted = false
)
