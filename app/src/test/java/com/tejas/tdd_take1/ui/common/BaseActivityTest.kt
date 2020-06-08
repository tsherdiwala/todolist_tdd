package com.tejas.tdd_take1.ui.common

import android.os.Build
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.tejas.tdd_take1.databinding.ActivityListBinding
import com.tejas.tdd_take1.ui.common.baseActivityTestDouble.TestBaseActivityHelper
import com.tejas.tdd_take1.ui.common.baseActivityTestDouble.TestInjectableBaseActivityHelper
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P])
class BaseActivityTest {

    @Test
    fun onCreate_setsDataBinding() {
        ActivityScenario.launch(TestBaseActivityHelper::class.java)
            .onActivity {
                assert(it.tBinding != null)
            }
    }

    @Test
    fun onCreate_assignsCorrectBinding() {
        ActivityScenario.launch(TestBaseActivityHelper::class.java)
            .onActivity {
                assert(it.tBinding is ActivityListBinding)
            }
    }

    @Test(expected = UninitializedPropertyAccessException::class)
    fun onCreate_doesNotInjectNonInjectableActivity() {

        ActivityScenario.launch(TestBaseActivityHelper::class.java).onActivity {
            @Suppress("SENSELESS_COMPARISON")
            assert(it.testInjection == null)
        }
    }

    @Test
    fun onCreate_injectsInjectableActivity() {
        ActivityScenario.launch(TestInjectableBaseActivityHelper::class.java).onActivity {
            @Suppress("SENSELESS_COMPARISON")
            assert(it.testInjection != null)
        }
    }
}