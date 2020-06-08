package com.tejas.tdd_take1.ui.newTodo

import android.os.Build
import android.view.View
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tejas.tdd_take1.R
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P]) //Required for RoboElectric error fix
class NewTodoActivityTest {

    @Test
    fun onCreate_initializesViewModel() {
        ActivityScenario.launch(NewTodoActivity::class.java).onActivity {
            assert(it.viewModel != null)
        }
    }

    @Test
    fun onCreate_inflatesCorrectLayout() {
        ActivityScenario.launch(NewTodoActivity::class.java).onActivity {
            assert(it.findViewById<View>(R.id.root_new_todo) != null)
        }
    }

}