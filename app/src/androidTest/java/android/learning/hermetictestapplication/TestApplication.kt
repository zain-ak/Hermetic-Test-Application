package android.learning.hermetictestapplication

import org.mockito.Mockito

class TestApplication : GreetingApplication() {
    private val clock: Clock by lazy {
        Mockito.mock(Clock::class.java)
    }

    override fun provideClock() : Clock = clock
}