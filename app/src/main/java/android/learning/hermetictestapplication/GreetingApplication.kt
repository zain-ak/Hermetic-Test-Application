package android.learning.hermetictestapplication

import android.app.Application

open class GreetingApplication : Application() {
    open fun provideClock() : Clock = Clock()
}