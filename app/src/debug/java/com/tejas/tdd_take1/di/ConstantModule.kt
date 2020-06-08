package com.tejas.tdd_take1.di

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ConstantModule {
    companion object {
        const val TEST_STRING_INJECTION = "TEST_STRING_INJECTION"
    }

    @Provides
    @Named(TEST_STRING_INJECTION)
    fun injectTestStringInjection() = TEST_STRING_INJECTION

}