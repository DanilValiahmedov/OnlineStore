package com.valimade.onlinestore

import android.app.Application
import com.valimade.onlinestore.product.di.AppComponent
import com.valimade.onlinestore.product.di.DaggerAppComponent
import com.valimade.onlinestore.product.di.module.NetworkModule
import com.valimade.onlinestore.product.di.module.RepositoryModule
import com.valimade.onlinestore.product.di.module.UseCaseModule

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
            .build()
    }
}