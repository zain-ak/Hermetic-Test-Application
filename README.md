<h1>Android Hermetic Practice Application - Dependency Injection Time 🕐 <img src="https://camo.githubusercontent.com/737e7380383ffcd2f3b9bf55c678f3b368feb730/68747470733a2f2f6c68352e676f6f676c6575736572636f6e74656e742e636f6d2f2d453259504c6c56416c30552f564a556350726756432d492f414141414141414147464d2f416b715a6e354e387272632f773839302d68313030392f657370726573736f5f6c6f636b75702e706e67" height="75" width="65" /></h1> 

A Kotlin-based Android Application for learning some of the more advanced concepts of the Espresso framework for UI Testing. This application is the second of two applications exploring these concepts. The concepts covered in this repo are:
 - Hermetic Test Environments
   - Dependency Injection
  
The first application, *🐱 Cat Names*, can be accessed [here](https://github.com/zain-ak/Advanced-Espresso-Practice-Application). *🐱 Cat Names* covers Espresso testing involving intents.
<br>
_General Note:_ There are two packages in folder for testing, once is for unit testing (**test**) and one is for instrumentation testing (**androidTest**). Instrumentation testing is UI testing so that's what Espresso testing falls under. Create all test files under the *androidTest* package.