<h1>Android Hermetic Practice Application - Dependency Injection Time 🕐 <img src="https://camo.githubusercontent.com/737e7380383ffcd2f3b9bf55c678f3b368feb730/68747470733a2f2f6c68352e676f6f676c6575736572636f6e74656e742e636f6d2f2d453259504c6c56416c30552f564a556350726756432d492f414141414141414147464d2f416b715a6e354e387272632f773839302d68313030392f657370726573736f5f6c6f636b75702e706e67" height="75" width="65" /></h1> 

A Kotlin-based Android Application for learning some of the more advanced concepts of the Espresso framework for UI Testing. This application is the second of two applications exploring these concepts. The concepts covered in this repo are:
 - Hermetic Test Environments
   - Dependency Injection
  
The first application, *🐱 Cat Names*, can be accessed [here](https://github.com/zain-ak/Advanced-Espresso-Practice-Application). *🐱 Cat Names* covers Espresso testing involving intents.
<br>
### Dependency Injection
Repeatable tests are ones where the results of a test will be the same as long as the application doesn't change. This requires the test environment to be *hermetic:*
   **Hermetic:** A test environment sealed from external dependencies.

In this application, an external dependency is being used for the time and it outputs a certain value based on the time. If you were to write a test for this, it would only pass at a certain time of day but fail at another time. This makes the test *unrepeatable.* To remedy this, you use a **dependency injection pattern**; this is a way to organize your code so that it's collected in one place.

For production, you're going to use the actual external dependencies. But for testing purposes, you'll use the organized code to have more control over your tests. So, the first step is to *extract the dependency*; in the case of this application, `DateTime()`  will be extracted by doing the following:

 - Creating two new classes called *Clock.kt* and *GreetingApplication.kt*
   - *Clock.kt* consists of the `DateTime()` variable only:
     
     ```java
     class Clock {
      fun getNow() = DateTime()
     }
     ```
   - *GreetingApplication.kt* will act as an external application to call the class `Clock`:
   
     ```java
     class GreetingApplication : Application() {
         fun provideClock() : Clock = Clock()
     }
     ```

     \*`GreetingApplication` also needs to be added to the *AndroidManifest.xml* under the `<application>` tag as `android:name=".GreetingApplication"`

 - Including `DateTime()` in *MainActivity.kt* using the above classes:
   
   ```java
   val app = application as GreetingApplication
   val now = app.provideClock().getNow()
   ```

In order to run tests on this new code, a new file, *TestApplication.kt*, will be created and inherit from the `GreetingApplication` class. As it inherits, the `provideClock()` method can be overridden:

```java
class TestApplication : GreetingApplication() {
    private lateinit var clock: Clock
    fun setClock(clock: Clock) {
        this.clock = clock
    }

    override fun provideClock() : Clock = clock
}
```

\*In order for `TestApplication` to make use of the `GreetingApplication` class as above, `GreetingApplication` has to be made `open` and so does its method, `provideClock()`.

A custom test runner is also created instead of using the default JUnitRunner:

```java
class CustomTestRunner: AndroidJUnitRunner() {
    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, "android.learning.hermetictestapplication.TestApplication", context)
    }
}
``` 


