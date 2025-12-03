package com.valimade.onlinestore

import android.app.Application
import com.valimade.onlinestore.di.AppComponent
import com.valimade.onlinestore.di.DaggerAppComponent
import com.valimade.onlinestore.di.module.NetworkModule
import com.valimade.onlinestore.di.module.RepositoryModule
import com.valimade.onlinestore.di.module.UseCaseModule
import com.valimade.onlinestore.di.module.ViewModelModule

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .networkModule(NetworkModule())
            .repositoryModule(RepositoryModule())
            .useCaseModule(UseCaseModule())
            .viewModelModule(ViewModelModule())
            .build()
    }
}