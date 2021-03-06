package com.tejas.tdd_take1.di

import com.tejas.tdd_take1.ui.common.baseActivityTestDouble.di.TestInjectableBaseActivityHelperModule
import dagger.Module

@Module(
    includes = [
        TestInjectableBaseActivityHelperModule::class,
        ConstantModule::class
    ]
)
abstract class BuildTypeVariantModule {

}