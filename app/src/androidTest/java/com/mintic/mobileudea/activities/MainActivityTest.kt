package com.mintic.mobileudea.activities


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.mintic.mobileudea.R
import org.hamcrest.Matchers.allOf
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val textView = onView(
            allOf(withId(R.id.game_title), withText("Backpack"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()))
        textView.check(matches(withText("Backpack")))

        val button_ajustes = onView(
            allOf(withId(R.id.button_settings), withText("AJUSTES"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()))
        button_ajustes.check(matches(isDisplayed()))

        val button_destinos = onView(
            allOf(withId(R.id.button_ini), withText("DESTINOS"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()))
        button_destinos.check(matches(isDisplayed()))

        val portraid = onView(
            allOf(withId(R.id.title_image), withContentDescription("TODO"),
                withParent(withParent(IsInstanceOf.instanceOf(android.widget.FrameLayout::class.java))),
                isDisplayed()))
        portraid.check(matches(isDisplayed()))

        val destinos_nav = onView(
            allOf(withId(R.id.poiListFragment), withContentDescription("Destinos"),
                withParent(withParent(withId(R.id.bottom_navigation_view))),
                isDisplayed()))
        destinos_nav.check(matches(isDisplayed()))

        val Preferencias_nav = onView(
            allOf(withId(R.id.settingsFragment), withContentDescription("Preferencias"),
                withParent(withParent(withId(R.id.bottom_navigation_view))),
                isDisplayed()))
        Preferencias_nav.check(matches(isDisplayed()))

    }
}
