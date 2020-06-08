package com.tejas.tdd_take1.ui.newTodo.di

import com.tejas.tdd_take1.ui.newTodo.NewTodoActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NewTodoActivityModule {

    @ContributesAndroidInjector(
        modules = [ViewInjectorModule::class]
    )
    abstract fun contributeActivity(): NewTodoActivity
}