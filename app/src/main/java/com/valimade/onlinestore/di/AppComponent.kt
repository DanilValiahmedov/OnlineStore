package com.valimade.onlinestore.di

import com.valimade.onlinestore.ui.MainActivity
import com.valimade.onlinestore.di.module.NetworkModule
import com.valimade.onlinestore.di.module.RepositoryModule
import com.valimade.onlinestore.di.module.UseCaseModule
import com.valimade.onlinestore.di.module.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(activity: MainActivity)
}