package com.tejas.tdd_take1.ui.list.di

import com.tejas.tdd_take1.di.scope.ActivityScoped
import com.tejas.tdd_take1.ui.list.ListActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ListActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ViewInjectorModule::class])
    abstract fun contributeActivity(): ListActivity
}