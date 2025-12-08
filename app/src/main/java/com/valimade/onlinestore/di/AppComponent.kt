package com.valimade.onlinestore.di

import android.app.Application
import com.valimade.onlinestore.di.module.DatabaseModule
import com.valimade.onlinestore.ui.MainActivity
import com.valimade.onlinestore.di.module.NetworkModule
import com.valimade.onlinestore.di.module.RepositoryModule
import com.valimade.onlinestore.di.module.UseCaseModule
import com.valimade.onlinestore.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        DatabaseModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        UseCaseModule::class,
        ViewModelModule::class,
    ]
)
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): AppComponent
    }

    fun inject(activity: MainActivity)
}