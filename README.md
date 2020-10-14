# Todo List App
<img src="https://media.giphy.com/media/sddeyNFVLFBDu4jp54/giphy.gif" width="300" align="right" hspace="20">

This app is an experiment in Kotlin Multiplatform. It is a simple one-page app which allows you to add a test to a recyclerview and to tap on the item to delete it.

After reading a few articles on Kotlin Multiplatform I settled on the interpretation of it from this article [Link](https://proandroiddev.com/kotlin-multiplatform-mvvm-clean-architecture-f20b99f90b95).

The reason I choose the above interpretation is because it mimics the MVVM pattern recommended by Google, inface the Moko MVVM library is even lifecycle aware. It also suggests using the Kodein Dependency Injection library which is extremely easy to use and setup.

## Architecture
* I have a ViewModel, TodoRepo and a Todo data class.
* The ViewModel is only concerned with retrieving data from the TodoRepo and delivering it to the View.
* The TodoRepo is the sole class that has access to the Todo list
* The Todo model only contains a string, it doesn't need to exist, but in the future I can imagine a check box or a date stamp being associated with every Todo entry and by having the model already created it means there's minimal refactoring involved.
* This setup made unit testing very easy.

## Folder Structure
The project has two module:
* `KotlinMultiplatform` this contains the app folder and share folder, it would also contain the ios folder
* `commonMain` is the **Kotlin Multiplatform** library that's accessible to both apps
