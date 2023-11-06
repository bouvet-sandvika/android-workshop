package com.example.androidworkshop.ui.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TodoListViewModel : ViewModel() {

    val todoList = mutableListOf<Todo>()

    fun deleteDoneTodos() {
        todoList.removeAll { it.isChecked }
    }
}