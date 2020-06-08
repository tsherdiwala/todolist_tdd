package com.tejas.tdd_take1.ui.list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tejas.tdd_take1.R
import com.tejas.tdd_take1.model.Todo
import com.tejas.tdd_take1.ui.list.adapter.viewholder.TodoVH


class TodoListAdapter(
    private val inflater: LayoutInflater
) : RecyclerView.Adapter<TodoVH>() {

    var todoList: List<Todo>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoVH {
        return TodoVH(
            inflater.inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = todoList?.size ?: 0

    override fun onBindViewHolder(holder: TodoVH, position: Int) {
        holder.bind(todoList!![position])
    }
}