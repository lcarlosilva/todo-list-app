package com.luiz.todo_list_app.ui.feature.add_edit

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luiz.todo_list_app.data.TodoRepository
import kotlinx.coroutines.launch

class AddEditViewModel(
    private val repository: TodoRepository,
) : ViewModel() {

    var title by mutableStateOf("")
        private set
    var description by mutableStateOf<String?>(null)
        private set

    fun onEvent(event: AddEditEvent) {
        when (event) {
            is AddEditEvent.TitleChanged -> {
                title = event.title
            }
            is AddEditEvent.DescriptionChanged -> {
                description = event.description
            }
            is AddEditEvent.Save -> {
                save()
            }
        }
    }

    private fun save() {
        viewModelScope.launch {
            repository.insert(title, description)
        }
    }

}