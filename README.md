# Prerequisites
Android Studio `3.5.x`
XCode `11.3.x`

# Structure
The project has three main subfolders:
* `app` is the Android app
* `ios` is the iOS app
* `shared` is the **Kotlin Multiplatform** library that's accessible to both apps

# Setup

You'll need to edit or override `local.properties` to point to your own Android SDK directory

To build the **Koltin Multiplatform** library you might want to run `./gradlew sharedcode:packForXCode` at least once.  
