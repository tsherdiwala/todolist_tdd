package com.tejas.tdd_take1.ui.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.tejas.tdd_take1.di.Injectable
import dagger.android.AndroidInjection


abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity() {

    protected abstract val layoutId: Int

    protected lateinit var binding: T
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        if (javaClass.isAnnotationPresent(Injectable::class.java)) {
            AndroidInjection.inject(this)
        }
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
    }
}