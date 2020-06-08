package com.tejas.tdd_take1.ui.list

import android.os.Build
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.tejas.tdd_take1.Event
import com.tejas.tdd_take1.model.Todo
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class ListActivityViewModelTest {

    private val viewModel = ListActivityViewModel()

    private val eventObserver: Observer<Event<Unit>> = mock()

    @Test
    fun addItem_triggersAddItemEvent() {
        viewModel.navigateAddItemEvent.observeForever(eventObserver)
        viewModel.addItem()
        verify(eventObserver, times(1)).onChanged(any())
    }

    @Test
    fun deleteItem_removesItem() {
        val itemToDelete = Todo("Title 2")
        val todoItems = mutableListOf<Todo>(
            Todo("Title 1"),
            itemToDelete
        )
        viewModel.items.value = todoItems

        viewModel.deleteItem(itemToDelete)

        assert(viewModel.items.value?.size == todoItems.size - 1)

        assert(
            viewModel.items.value?.find { it.id == itemToDelete.id } == null
        )
    }

}