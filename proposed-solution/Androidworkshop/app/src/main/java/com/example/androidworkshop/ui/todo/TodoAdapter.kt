package com.example.androidworkshop.ui.todo

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidworkshop.R
import com.example.androidworkshop.databinding.ItemTodoBinding


class TodoAdapter(
    private val todos: MutableList<Todo>,
    private val viewModelUpdater: ViewModelUpdater
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false))
    }

    fun addTodo(todo: Todo) {
        viewModelUpdater.addTodo(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneTodos() {
        viewModelUpdater.deleteDoneTodos()
        notifyDataSetChanged()
    }

    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if(isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val curTodo = todos[position]
        holder.itemView.apply {
            val binding = ItemTodoBinding.bind(this)

            binding.tvTodoTitle.text = curTodo.title
            binding.cbDone.isChecked = curTodo.isChecked
            toggleStrikeThrough(binding.tvTodoTitle, curTodo.isChecked)
            binding.cbDone.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(binding.tvTodoTitle, isChecked)
                curTodo.isChecked = !curTodo.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        return todos.size
    }

    interface ViewModelUpdater {
        fun addTodo(todo: Todo)
        fun deleteDoneTodos()
    }
}