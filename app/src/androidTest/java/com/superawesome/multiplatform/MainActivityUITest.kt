package com.superawesome.multiplatform

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaListAssertions.assertDisplayedAtPosition
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import com.schibsted.spain.barista.interaction.BaristaKeyboardInteractions.closeKeyboard
import com.superawesome.multiplatform.ui.MainActivity
import org.junit.Test


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {

    @Rule
    @JvmField
    var mainActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun addOneTodoAndAssertRecyclerView() {
        clickOn(R.id.content_main_add_button)
        clickOn(R.id.bottom_sheet_todo_edit_text)
        writeTo(R.id.bottom_sheet_todo_edit_text, "espresso test")
        closeKeyboard()
        clickOn(R.id.bottom_sheet_todo_button)
        assertDisplayedAtPosition(R.id.content_main_recycler_view, 0, "espresso test")
    }
}
