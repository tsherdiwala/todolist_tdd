package com.tejas.tdd_take1.ui.list

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.tejas.tdd_take1.EventObserver
import com.tejas.tdd_take1.R
import com.tejas.tdd_take1.databinding.ActivityListBinding
import com.tejas.tdd_take1.di.ClassNamed
import com.tejas.tdd_take1.di.Injectable
import com.tejas.tdd_take1.ui.common.BaseActivity
import com.tejas.tdd_take1.ui.newTodo.NewTodoActivity
import javax.inject.Inject

@Injectable
class ListActivity : BaseActivity<ActivityListBinding>() {

    @Inject
    @field:ClassNamed(ListActivityViewModel::class)
    lateinit var viewModel: ListActivityViewModel

    override val layoutId = R.layout.activity_list

    @Inject
    lateinit var adapter: RecyclerView.Adapter<*>

    @Inject
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.todoRV.layoutManager = layoutManager
        binding.todoRV.adapter = adapter

        val activity = this

        viewModel.navigateAddItemEvent.observe(activity, EventObserver {
            startActivity(Intent(activity, NewTodoActivity::class.java))
        })
    }
}