package com.example.timetable_compose_9901.main

import android.app.Application
import android.content.Context

// Not object class. AndroidManifest.xml error happen.
class App : Application() {

    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun applicationContext() : Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        // initialize for any

        // Use ApplicationContext.
        // example: SharedPreferences etc...
        val context: Context = App.applicationContext()
    }
}

//class MyApp : Application() {
//    override fun onCreate() {
//        instance = this
//        super.onCreate()
//    }
//
//    companion object {
//        var instance: MyApp? = null
//            private set
//
//        // or return instance.getApplicationContext();
//        val context: Context?
//            get() = instance
//        // or return instance.getApplicationContext();
//    }
//}