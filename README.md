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

For production, you're going to use the actual external dependencies. But for testing purposes, you'll use the organized code to have more control over your tests. So, the first step is to *extract the dependency*; in the case of this application, `DateTime() `  will be extracted.

 - 

