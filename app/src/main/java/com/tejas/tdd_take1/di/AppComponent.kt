package com.tejas.tdd_take1.di

import com.tejas.tdd_take1.TDDApplication
import com.tejas.tdd_take1.ui.list.di.ListActivityModule
import com.tejas.tdd_take1.ui.newTodo.di.NewTodoActivityModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        BuildTypeVariantModule::class,

        // ui modules
        ListActivityModule::class,
        NewTodoActivityModule::class
    ]
)
interface AppComponent {
    fun inject(app: TDDApplication)
}