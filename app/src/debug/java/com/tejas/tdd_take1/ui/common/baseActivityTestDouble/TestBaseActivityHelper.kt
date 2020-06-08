package com.tejas.tdd_take1.ui.common.baseActivityTestDouble

import androidx.databinding.ViewDataBinding
import com.tejas.tdd_take1.R
import com.tejas.tdd_take1.databinding.ActivityListBinding
import com.tejas.tdd_take1.di.BuildTypeVariantModule
import com.tejas.tdd_take1.di.ConstantModule
import com.tejas.tdd_take1.ui.common.BaseActivity
import javax.inject.Inject
import javax.inject.Named

class TestBaseActivityHelper : BaseActivity<ActivityListBinding>() {

    @Inject
    @field:Named(ConstantModule.TEST_STRING_INJECTION)
    lateinit var testInjection: String

    override val layoutId = R.layout.activity_list

    val tBinding: ViewDataBinding
        get() = binding
}