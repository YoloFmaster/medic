package com.pushkovav.medic

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class AntefactionActivityIntentTest {

    @JvmField
    @Rule
    var activityScenarioRule = ActivityScenarioRule(AntefactionActivity::class.java)


    @Test
    fun espressoTest(){
        onView(withId(R.id.layout_AntefactionActivity))
            .check(matches(isDisplayed()))
        onView(withId(R.id.editText))
            .perform(typeText("ldfd@dlf.sdf"), closeSoftKeyboard())
        onView(withId(R.id.buttonNext))
            .perform(click())
        onView(withId(R.id.layout_ConfirmitionEmailActivity))
            .check(matches(isDisplayed()))
    }

}