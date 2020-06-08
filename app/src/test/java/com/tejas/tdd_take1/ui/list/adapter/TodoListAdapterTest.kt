package com.tejas.tdd_take1.ui.list.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.*
import com.tejas.tdd_take1.R
import com.tejas.tdd_take1.model.Todo
import com.tejas.tdd_take1.ui.list.adapter.viewholder.TodoVH
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P]) //Required for RoboElectric error fix
class TodoListAdapterTest {


    @Test
    fun todoList_new_notifyDataSetChanged() {
        val inflater = mock<LayoutInflater>()
        val todoListAdapter = spy(TodoListAdapter(inflater))
        todoListAdapter.todoList = listOf()
        verify(todoListAdapter).notifyDataSetChanged()
    }

    @Test
    fun onCreateViewHolder_inflatesCorrectLayout() {
        //arrange
        val layoutInflater = mock<LayoutInflater>()
        val todoListAdapter = TodoListAdapter(layoutInflater)
        val parent = mock<ViewGroup>()

        val mockItemView = mock<View>()
        whenever(mockItemView.findViewById<TextView>(any())).thenReturn(mock())

        whenever(layoutInflater.inflate(any<Int>(), any(), any())).thenReturn(mockItemView)

        //act
        todoListAdapter.onCreateViewHolder(parent, 0)

        //assert
        verify(layoutInflater).inflate(R.layout.item_todo, parent, false)
    }

    @Test
    fun getItemCount_noItems_returnsZero() {
        val layoutInflater = mock<LayoutInflater>()
        val todoListAdapter = TodoListAdapter(layoutInflater)

        assert(todoListAdapter.itemCount == 0)
    }


    @Test
    fun getItemCount_withItems_returnsCorrectLength() {
        val layoutInflater = mock<LayoutInflater>()
        val todoListAdapter = TodoListAdapter(layoutInflater)

        todoListAdapter.todoList = listOf(
            Todo("Title 1")
        )

        assert(todoListAdapter.itemCount == 1)
    }

    @Test
    fun onBindViewHolder_bindsViewHolder() {
        //arrange
        val layoutInflater = mock<LayoutInflater>()
        val todoListAdapter = TodoListAdapter(layoutInflater)
        val viewHolder = mock<TodoVH>()
        val todoList = listOf<Todo>(mock())
        todoListAdapter.todoList = todoList

        //act
        todoListAdapter.onBindViewHolder(viewHolder, 0)

        //assert
        verify(viewHolder).bind(any())
    }

    @Test
    fun onBindViewHolder_bindsViewHolderWithCorrectPosition() {
        //arrange
        val layoutInflater = mock<LayoutInflater>()
        val todoListAdapter = TodoListAdapter(layoutInflater)
        val viewHolder = mock<TodoVH>()
        val boundTodo = mock<Todo>()
        val todoList = listOf(boundTodo)
        todoListAdapter.todoList = todoList

        //act
        todoListAdapter.onBindViewHolder(viewHolder, 0)

        //assert
        verify(viewHolder).bind(boundTodo)
    }

    @Test
    fun onBindViewHolder_nullItems_throwsError() {
        val todoListAdapter = TodoListAdapter(mock())

        var hasThrownException = false
        try{
            todoListAdapter.onBindViewHolder(mock(), 0)
        }catch (e: KotlinNullPointerException){
            hasThrownException = true
        }

        assert(hasThrownException)
    }

}