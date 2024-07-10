package com.pushkovav.medic

import android.os.SystemClock
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test


class ConfirmationEmailActivityTest {
    @JvmField
    @Rule
    var activityScenarioRule = ActivityScenarioRule(ConfirmationEmailActivity::class.java)

    @Test
    fun inputTrueCode(){
        onView(withId(R.id.layout_ConfirmitionEmailActivity))
            .check(matches(isDisplayed()))
        onView(withId(R.id.txt1))
            .perform(replaceText("1"))
        onView(withId(R.id.txt2))
            .perform(replaceText("2"))
        onView(withId(R.id.txt3))
            .perform(replaceText("3"))
        onView(withId(R.id.txt4))
            .perform(replaceText("4"))
        SystemClock.sleep(100)
        onView(withId(R.id.layout_CreatePasswordActivity))
            .check(matches(isDisplayed()))
    }
}