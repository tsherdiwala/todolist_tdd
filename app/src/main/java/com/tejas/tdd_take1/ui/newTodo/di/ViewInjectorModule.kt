package com.tejas.tdd_take1.ui.newTodo.di

import androidx.lifecycle.ViewModelProvider
import com.tejas.tdd_take1.di.ClassNamed
import com.tejas.tdd_take1.ui.newTodo.NewTodoActivity
import com.tejas.tdd_take1.ui.newTodo.NewTodoViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewInjectorModule {

    @Provides
    @ClassNamed(NewTodoViewModel::class)
    fun provideViewModel(activity: NewTodoActivity): NewTodoViewModel {
        return ViewModelProvider(activity).get(NewTodoViewModel::class.java)
    }
}