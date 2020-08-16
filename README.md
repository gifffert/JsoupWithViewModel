# JsoupWithViewModel
Parsing data from sites using Jsoup and ViewModel.

Dependencies:

classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72"
classpath "com.google.gms:google-services:4.3.3"
classpath "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0"


mavenCentral()
maven { url 'https://jitpack.io' }


apply plugin: 'kotlin-kapt'


// view model and live data
implementation 'androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0'
implementation 'androidx.lifecycle:lifecycle-livedata-ktx:2.2.0'
implementation 'androidx.lifecycle:lifecycle-extensions:2.2.0'
// recyclerview and cardview
implementation 'androidx.recyclerview:recyclerview:1.1.0'
implementation 'androidx.cardview:cardview:1.0.0'
//picasso
implementation 'com.squareup.picasso:picasso:2.71828'
// jsoup
implementation 'org.jsoup:jsoup:1.12.1'
// data binding
kapt 'com.android.databinding:compiler:3.2.0-alpha10'
//coroutines
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.8"
implementation "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.8"


apply plugin: 'androidx.navigation.safeargs.kotlin'
