package com.tejas.tdd_take1.di

import com.tejas.tdd_take1.TDDApplication
import dagger.android.support.DaggerApplication

object AppInjector {
    fun init(app: TDDApplication){
        DaggerAppComponent
            .builder()
            .build()
            .inject(app)
    }
}