package com.tejas.tdd_take1.ui.list.di

import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tejas.tdd_take1.di.ClassNamed
import com.tejas.tdd_take1.di.scope.ActivityScoped
import com.tejas.tdd_take1.ui.list.ListActivity
import com.tejas.tdd_take1.ui.list.ListActivityViewModel
import com.tejas.tdd_take1.ui.list.adapter.TodoListAdapter
import dagger.Module
import dagger.Provides

@Module
class ViewInjectorModule {

    @Provides
    @ClassNamed(ListActivityViewModel::class)
    fun provideViewModel(
        activity: ListActivity
    ): ListActivityViewModel {
        return ViewModelProvider(activity).get(ListActivityViewModel::class.java)
    }

    @Provides
    @ActivityScoped
    fun provideAdapter(activity: ListActivity): RecyclerView.Adapter<*> {
        return TodoListAdapter(LayoutInflater.from(activity))
    }

    @Provides
    @ActivityScoped
    fun provideLayoutManager(activity: ListActivity): RecyclerView.LayoutManager {
        return LinearLayoutManager(activity)
    }
}