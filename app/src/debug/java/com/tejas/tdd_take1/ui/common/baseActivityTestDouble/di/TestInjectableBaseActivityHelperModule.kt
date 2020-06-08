package com.tejas.tdd_take1.ui.common.baseActivityTestDouble.di

import com.tejas.tdd_take1.ui.common.baseActivityTestDouble.TestInjectableBaseActivityHelper
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class TestInjectableBaseActivityHelperModule {

    @ContributesAndroidInjector()
    abstract fun contributeTestInjectableBaseActivityHelper(): TestInjectableBaseActivityHelper
}