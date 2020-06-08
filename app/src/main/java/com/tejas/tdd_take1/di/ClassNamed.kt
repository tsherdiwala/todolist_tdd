package com.tejas.tdd_take1.di

import javax.inject.Qualifier
import kotlin.reflect.KClass

@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ClassNamed(val value: KClass<out Any>)