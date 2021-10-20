package com.mintic.mobileudea.activities


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.mintic.mobileudea.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class PreferencesTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun preferencesTest() {
        val bottomNavigationItemView = onView(
            allOf(withId(R.id.settingsFragment), withContentDescription("Preferencias"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.bottom_navigation_view),
                        0),
                    2),
                isDisplayed()))
        bottomNavigationItemView.perform(click())

        val textView = onView(
            allOf(withId(android.R.id.title), withText("Versión 3.0 2021"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()))
        textView.check(matches(withText("Versión 3.0 2021")))

        val textView2 = onView(
            allOf(withId(android.R.id.title), withText("Activar Notificaciones"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()))
        textView2.check(matches(withText("Activar Notificaciones")))

        val textView3 = onView(
            allOf(withId(android.R.id.title), withText("Activar Sonido"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java))),
                isDisplayed()))
        textView3.check(matches(withText("Activar Sonido")))

        val switch_ = onView(
            allOf(withId(R.id.switchWidget), withText("OFF"),
                withParent(allOf(withId(android.R.id.widget_frame),
                    withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))),
                isDisplayed()))
        switch_.check(matches(isDisplayed()))

        val switch_2 = onView(
            allOf(withId(R.id.switchWidget), withText("OFF"),
                withParent(allOf(withId(android.R.id.widget_frame),
                    withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))),
                isDisplayed()))
        switch_2.check(matches(isDisplayed()))

        val recyclerView = onView(
            allOf(withId(R.id.recycler_view),
                childAtPosition(
                    withId(android.R.id.list_container),
                    0)))
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(3, click()))

        val recyclerView2 = onView(
            allOf(withId(R.id.recycler_view),
                childAtPosition(
                    withId(android.R.id.list_container),
                    0)))
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(4, click()))

        val switch_3 = onView(
            allOf(withId(R.id.switchWidget), withText("ON"),
                withParent(allOf(withId(android.R.id.widget_frame),
                    withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))),
                isDisplayed()))
        switch_3.check(matches(isDisplayed()))

        val switch_4 = onView(
            allOf(withId(R.id.switchWidget), withText("ON"),
                withParent(allOf(withId(android.R.id.widget_frame),
                    withParent(IsInstanceOf.instanceOf(android.widget.LinearLayout::class.java)))),
                isDisplayed()))
        switch_4.check(matches(isDisplayed()))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int,
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
