package com.testdevlab.numbertapper

import android.app.Application
import com.testdevlab.numbertapper.common.LineNumberDebugTree
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(LineNumberDebugTree())
        }
        Timber.d("Lingo app created")
    }
}
