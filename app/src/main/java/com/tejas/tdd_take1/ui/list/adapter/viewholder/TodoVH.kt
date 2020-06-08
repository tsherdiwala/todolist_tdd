package com.tejas.tdd_take1.ui.list.adapter.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tejas.tdd_take1.R
import com.tejas.tdd_take1.model.Todo

class TodoVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val titleTV: TextView = itemView.findViewById(R.id.titleTV)

    fun bind(todo: Todo) {
        titleTV.text = todo.title
    }
}