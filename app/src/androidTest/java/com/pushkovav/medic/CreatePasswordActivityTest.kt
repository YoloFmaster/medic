package com.pushkovav.medic

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class CreatePasswordActivityTest(){
    @JvmField
    @Rule
    var activityScenarioRule = ActivityScenarioRule(CreatePasswordActivity::class.java)

    @Test
    fun createPassword(){
        onView(withId(R.id.layout_CreatePasswordActivity))
            .check(matches(isDisplayed()))
        onView(withId(R.id.num0))
            .perform(click())
        onView(withId(R.id.num1))
            .perform(click())
        onView(withId(R.id.num2))
            .perform(click())
        onView(withId(R.id.num3))
            .perform(click())
        onView(withId(R.id.layout_CreateUserCard))
            .check(matches(isDisplayed()))
    }

    @Test
    fun skipCreatingPassword(){
        onView(withId(R.id.buttonSkip))
            .perform(click())
        onView(withId(R.id.layout_CreateUserCard))
            .check(matches(isDisplayed()))
    }

    @Test
    fun checkAllButton(){
        onView(withId(R.id.num0))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.num1))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.num2))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.num3))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.num4))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.num5))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.num6))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.num7))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.num8))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.num9))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
        onView(withId(R.id.delBtnImg))
            .perform(click())
    }
}