package android.learning.hermetictestapplication

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.joda.time.DateTime
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @JvmField @Rule
    var activityTestRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Test
    fun testEvening() {
        val app = InstrumentationRegistry.getTargetContext().applicationContext as TestApplication
        val clock = app.provideClock()
        Mockito.`when`(clock.getNow()).thenReturn(DateTime().withHourOfDay(20))

        activityTestRule.launchActivity(null)

        onView(withId(R.id.greeting))
                .check(matches(withText(R.string.greeting_evening)))
    }

    @Test
    fun testMorning() {
        val app = InstrumentationRegistry.getTargetContext().applicationContext as TestApplication
        val clock = app.provideClock()
        Mockito.`when`(clock.getNow()).thenReturn(DateTime().withHourOfDay(10))

        activityTestRule.launchActivity(null)

        onView(withId(R.id.greeting))
                .check(matches(withText(R.string.greeting_morning)))
    }

    @Test
    fun testAfternoon() {
        val app = InstrumentationRegistry.getTargetContext().applicationContext as TestApplication
        val clock = app.provideClock()
        Mockito.`when`(clock.getNow()).thenReturn(DateTime().withHourOfDay(15))

        activityTestRule.launchActivity(null)

        onView(withId(R.id.greeting))
                .check(matches(withText(R.string.greeting_afternoon)))
    }

    @Test
    fun testNight() {
        val app = InstrumentationRegistry.getTargetContext().applicationContext as TestApplication
        val clock = app.provideClock()
        Mockito.`when`(clock.getNow()).thenReturn(DateTime().withHourOfDay(0))

        activityTestRule.launchActivity(null)

        onView(withId(R.id.greeting))
                .check(matches(withText(R.string.greeting_night)))
    }



}