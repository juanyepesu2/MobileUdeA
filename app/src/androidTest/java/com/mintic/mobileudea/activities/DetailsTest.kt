package com.mintic.mobileudea.activities


import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import com.mintic.mobileudea.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class DetailsTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun detailsTest() {
        val materialButton = onView(
            allOf(withId(R.id.button_ini), withText("Destinos"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.FrameLayout")),
                        0),
                    1),
                isDisplayed()))
        materialButton.perform(click())

        val recyclerView = onView(
            allOf(withId(R.id.poi_list),
                childAtPosition(
                    withClassName(`is`("android.widget.FrameLayout")),
                    0)))
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        val textView = onView(
            allOf(withId(R.id.description1_POIs),
                withText("Guatapé es un municipio de Colombia, localizado en la subregión Oriente del departamento de Antioquia. Se encuentra a 79 kilómetros de la ciudad de Medellín. El municipio posee una extensión de 76 Km2. Es conocido como el Paraíso turístico de Antioquia y Pueblo de Zócalos, también es conocido como el Embalse Peñol-Guatapé, el mayor de Colombia."),
                withParent(withParent(withId(R.id.scrollView))),
                isDisplayed()))
        textView.check(matches(isDisplayed()))

        val textView2 = onView(
            allOf(withId(R.id.location_value), withText("Colombia, departamento de Antioquia"),
                withParent(withParent(withId(R.id.scrollView))),
                isDisplayed()))
        textView2.check(matches(isDisplayed()))

        val textView3 = onView(
            allOf(withId(R.id.temperature_value), withText("24°C en promedio."),
                withParent(withParent(withId(R.id.scrollView))),
                isDisplayed()))
        textView3.check(matches(isDisplayed()))

        val textView4 = onView(
            allOf(withId(R.id.places_interest),
                withText("  • Iglesia Nuestra Señora del Carmen.\n  • Capilla de Nuestra Señora de Santa Ana.\n  • Monasterio de los Monjes Benedictinos.\n  • Museo Histórico Comunitario.\n  • Calle del Recuerdo.\n  • Museo del Zócalo.\n  • Piedra del Peñol o Peñón de Guatapé.\n  • Parque recreativo la Culebra.\n  • Parque Místico Guatapé.\n  • Malecón - Navegación y pesca en la represa."),
                withParent(withParent(withId(R.id.scrollView))),
                isDisplayed()))
        textView4.check(matches(isDisplayed()))

        val button = onView(
            allOf(withId(R.id.button_map), withText("VER EN MAPA"),
                withParent(withParent(withId(R.id.scrollView))),
                isDisplayed()))
        button.check(matches(isDisplayed()))

        val button2 = onView(
            allOf(withId(R.id.button_info), withText("MÁS INFO"),
                withParent(withParent(withId(R.id.scrollView))),
                isDisplayed()))
        button2.check(matches(isDisplayed()))

        val button3 = onView(
            allOf(withId(R.id.button_info), withText("MÁS INFO"),
                withParent(withParent(withId(R.id.scrollView))),
                isDisplayed()))
        button3.check(matches(isDisplayed()))
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
