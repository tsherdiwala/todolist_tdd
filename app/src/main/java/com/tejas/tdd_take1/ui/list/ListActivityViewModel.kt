package com.tejas.tdd_take1.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tejas.tdd_take1.Event
import com.tejas.tdd_take1.model.Todo

class ListActivityViewModel : ViewModel() {

    private val _navigateAddItemEvent = MutableLiveData<Event<Unit>>()
    val navigateAddItemEvent: LiveData<Event<Unit>>
        get() = _navigateAddItemEvent

    val items = MutableLiveData<List<Todo>>()

    fun addItem(){
        _navigateAddItemEvent.value = Event(Unit)
    }

    fun deleteItem(item: Todo) {
        val itemsAfterRemoval = items.value?.filter { it.id != item.id } ?: listOf()
        items.value = itemsAfterRemoval
    }
}