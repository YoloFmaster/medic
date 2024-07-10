package com.pushkovav.medic

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class CreateUserCardActivityTest{
    @JvmField
    @Rule
    var activityScenarioRule = ActivityScenarioRule(CreateUserCardActivity::class.java)

    @Test
    fun nextScreen(){
        onView(withId(R.id.layout_CreateUserCard))
            .check(matches(isDisplayed()))
        onView(withId(R.id.textName))
            .perform(replaceText("Алексей"))
        onView(withId(R.id.textMiddleName))
            .perform(replaceText("Владимирович"), closeSoftKeyboard())
        onView(withId(R.id.textLastName))
            .perform(replaceText("Пушков"), closeSoftKeyboard())
        onView(withId(R.id.textDateOfBirth))
            .perform(replaceText("05.12.1995"), closeSoftKeyboard())
        onView(withId(R.id.spinnerGender)).perform(click())
        onView(withText("Мужской")).perform(click())
        onView(withId(R.id.createCard))
            .perform(click())
        onView(withId(R.id.layout_main))
            .check(matches(isDisplayed()))
    }

}