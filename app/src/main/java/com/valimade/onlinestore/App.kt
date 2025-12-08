package com.valimade.onlinestore

import android.app.Application
import com.valimade.onlinestore.di.AppComponent
import com.valimade.onlinestore.di.DaggerAppComponent

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.factory()
            .create(this)
    }
}