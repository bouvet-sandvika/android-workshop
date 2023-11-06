package com.example.androidworkshop.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidworkshop.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {

    private var _binding: FragmentTodoListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var todoListViewModel: TodoListViewModel
    private lateinit var todoAdapter: TodoAdapter

    private val viewModelUpdater = object : TodoAdapter.ViewModelUpdater {
        override fun addTodo(todo: Todo) {
            todoListViewModel.todoList.add(todo)
        }

        override fun deleteDoneTodos() {
            todoListViewModel.deleteDoneTodos()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        todoListViewModel = ViewModelProvider(this)[TodoListViewModel::class.java]

        _binding = FragmentTodoListBinding.inflate(inflater, container, false)
        val root: View = binding.root

        todoAdapter = TodoAdapter(todoListViewModel.todoList, viewModelUpdater)
        binding.rvTodoItems.adapter = todoAdapter
        binding.rvTodoItems.layoutManager = LinearLayoutManager(context)

        binding.btnAddTodo.setOnClickListener { onAddTodoClicked() }
        binding.btnDeleteDoneTodos.setOnClickListener { onDeleteTodoClicked() }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun onAddTodoClicked() {
        val todoTitle = binding.etTodoTitle.text.toString()
        if(todoTitle.isNotEmpty()) {
            val todo = Todo(todoTitle)
            todoAdapter.addTodo(todo)
            binding.etTodoTitle.text.clear()
        }
    }

    private fun onDeleteTodoClicked() {
        todoAdapter.deleteDoneTodos()
    }
}