package android.learning.hermetictestapplication

import android.app.Application

class GreetingApplication : Application() {
    fun provideClock() : Clock = Clock()
}