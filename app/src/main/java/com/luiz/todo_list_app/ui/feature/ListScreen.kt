package com.luiz.todo_list_app.ui.feature

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.luiz.todo_list_app.domain.Todo
import com.luiz.todo_list_app.domain.todoOne
import com.luiz.todo_list_app.domain.todoThree
import com.luiz.todo_list_app.domain.todoTwo
import com.luiz.todo_list_app.ui.components.TodoItem
import com.luiz.todo_list_app.ui.theme.TodolistappTheme

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
    navigateToAddEditScreen: (id: Long?) -> Unit,
) {
    ListContent(
        todos = emptyList(),
        onAddItemClick = navigateToAddEditScreen
    )
}

@Composable
fun ListContent(
    todos: List<Todo>,
    onAddItemClick: (id: Long?) -> Unit,
) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = { onAddItemClick(null) }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .consumeWindowInsets(paddingValues),
            contentPadding = PaddingValues(16.dp)
        ) {
            itemsIndexed(todos) { index, todo ->
                TodoItem(
                    todo = todo,
                    onCompletedChange = {},
                    onItemClick = {},
                    onDeleteClick = {}
                )
                if (index < todos.lastIndex) {
                    Spacer(modifier = Modifier.height(10.dp))
                }

            }
        }
    }
}

@Preview
@Composable
private fun ListContentPreview() {
    TodolistappTheme {
        ListContent(
            todos = listOf(
                todoOne,
                todoTwo,
                todoThree
            ),
            onAddItemClick = {}
        )
    }
}