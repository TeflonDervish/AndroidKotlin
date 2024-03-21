package ru.myitschool.lab23

import androidx.test.espresso.Espresso.onView
 import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers
 import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class EditPropertyTest {

    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun clickLoginButton() {
        onView(withId(R.id.property_text)).perform(typeText("RESUMED"))
        onView(ViewMatchers.isRoot()).perform(closeSoftKeyboard())
        onView(withId(R.id.submit_button)).perform(click())

    }
}