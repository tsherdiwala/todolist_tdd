package com.tejas.tdd_take1.ui.newTodo

import com.tejas.tdd_take1.R
import com.tejas.tdd_take1.databinding.ActivityNewTodoBinding
import com.tejas.tdd_take1.di.ClassNamed
import com.tejas.tdd_take1.di.Injectable
import com.tejas.tdd_take1.ui.common.BaseActivity
import javax.inject.Inject

@Injectable
class NewTodoActivity : BaseActivity<ActivityNewTodoBinding>() {

    @Inject
    @field:ClassNamed(NewTodoViewModel::class)
    lateinit var viewModel: NewTodoViewModel

    override val layoutId = R.layout.activity_new_todo
}