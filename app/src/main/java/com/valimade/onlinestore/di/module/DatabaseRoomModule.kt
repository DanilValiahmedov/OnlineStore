package com.valimade.onlinestore.di.module

import android.content.Context
import androidx.room.Room
import com.valimade.onlinestore.data.db.room.AppDatabase
import com.valimade.onlinestore.data.db.room.ProductDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseRoomModule(private val context: Context) {

    @Provides
    @Singleton
    fun provideRoomDatabase(): AppDatabase {
        return Room.databaseBuilder(
            context,
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