package com.tejas.tdd_take1.ui.list

import android.os.Build
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.mock
import com.tejas.tdd_take1.Event
import com.tejas.tdd_take1.R
import com.tejas.tdd_take1.ui.list.adapter.TodoListAdapter
import com.tejas.tdd_take1.ui.newTodo.NewTodoActivity
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config


@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P]) //Required for RoboElectric error fix
class ListActivityTest {


    @Test
    fun onCreate_setContentView() {
        val scenario: ActivityScenario<ListActivity> =
            ActivityScenario.launch(ListActivity::class.java)
        scenario.onActivity {
            assert(it.findViewById<View>(R.id.root_list) != null)
        }
    }

    @Test
    fun onCreate_initializesViewModel() {
        ActivityScenario.launch(ListActivity::class.java).onActivity {
            assert(it.viewModel != null)
        }
    }

    @Test
    fun onCreate_initializesViewModelOfTypeListActivityViewModel() {
        ActivityScenario.launch(ListActivity::class.java).onActivity {
            assert(it.viewModel is ListActivityViewModel)
        }
    }

    @Test
    fun activityContainsRecyclerView() {
        ActivityScenario.launch(ListActivity::class.java).onActivity {

            val view = it.findViewById<RecyclerView>(R.id.todoRV)

            assert(view != null)
            assert(view is RecyclerView)
        }
    }


    @Test
    fun onCreate_setsAdapterOnRecyclerView() {
        ActivityScenario.launch(ListActivity::class.java).onActivity {
            assert(it.findViewById<RecyclerView>(R.id.todoRV).adapter != null)
        }
    }

    @Test
    fun onCreate_initializesAdapter() {
        ActivityScenario.launch(ListActivity::class.java).onActivity {
            assert(it.adapter != null)
        }
    }


    @Test
    fun onCreate_initializesTodoListAdapter() {
        ActivityScenario.launch(ListActivity::class.java).onActivity {
            assert(it.adapter is TodoListAdapter)
        }
    }

    @Test
    fun onCreate_recyclerViewHasLayoutAdapter() {
        ActivityScenario.launch(ListActivity::class.java).onActivity {
            val view = it.findViewById<RecyclerView>(R.id.todoRV)
            assert(view.layoutManager != null)
        }
    }

    @Test
    fun onAdd_navigatesToNewActivity() {
        ActivityScenario.launch(ListActivity::class.java).onActivity { activity ->

            activity.viewModel.addItem()

            activity.viewModel.navigateAddItemEvent.observe(activity, Observer {
                val startedIntent = shadowOf(activity).nextStartedActivity
                val shadowIntent = shadowOf(startedIntent)
                assert(shadowIntent.intentClass == NewTodoActivity::class.java)
            })
        }
    }
}