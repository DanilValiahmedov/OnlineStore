package com.valimade.onlinestore.di.module

import android.app.Application
import androidx.room.Room
import com.valimade.onlinestore.data.db.room.AppDatabase
import com.valimade.onlinestore.data.db.room.ProductDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseRoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application): AppDatabase {
        return Room.databaseBuilder(
            application,
            AppDatabase::class.java,
            "room_products.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideProductDao(db: AppDatabase): ProductDao {
        return db.productDao()
    }
}