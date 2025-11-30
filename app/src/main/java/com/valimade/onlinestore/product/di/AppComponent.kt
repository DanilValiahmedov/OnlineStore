package com.valimade.onlinestore.product.di

import com.valimade.onlinestore.MainActivity
import com.valimade.onlinestore.product.di.module.NetworkModule
import com.valimade.onlinestore.product.di.module.RepositoryModule
import com.valimade.onlinestore.product.di.module.UseCaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}