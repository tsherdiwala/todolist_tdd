package com.tejas.tdd_take1.ui.list.adapter.viewholder

import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.tejas.tdd_take1.R
import com.tejas.tdd_take1.model.Todo
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(sdk = [Build.VERSION_CODES.P]) //Required for RoboElectric error fix
class TodoVHTest {

    @Test
    fun bind_setsTitleTextView() {
        val itemView = mock<View>()
        val titleTV = mock<TextView>()
        whenever(itemView.findViewById<TextView>(R.id.titleTV)).thenReturn(titleTV)

        val title = "Test Title"
        val todo = Todo(title)

        val viewHolder = TodoVH(itemView)
        viewHolder.bind(todo)

        verify(titleTV).text = title

    }

}