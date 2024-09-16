package com.luiz.todo_list_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.ui.Modifier
import com.luiz.todo_list_app.navigation.TodoNavHost
import com.luiz.todo_list_app.ui.theme.TodolistappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Box(
                modifier = Modifier.safeDrawingPadding()
            ) {
                TodolistappTheme {
                    TodoNavHost()
                }
            }
        }
    }
}

