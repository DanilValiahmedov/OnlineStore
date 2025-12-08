package com.valimade.onlinestore.di.module

import android.app.Application
import com.j256.ormlite.dao.Dao
import com.valimade.onlinestore.data.db.AppDatabaseHelper
import com.valimade.onlinestore.data.db.ProductEntity
import com.valimade.onlinestore.data.db.ProductLocalDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabaseHelper(app: Application): AppDatabaseHelper {
        return AppDatabaseHelper(app)
    }

    @Provides
    @Singleton
    fun provideProductDao(helper: AppDatabaseHelper): Dao<ProductEntity, Int> {
        return helper.getDao(ProductEntity::class.java)
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(
        dao: Dao<ProductEntity, Int>
    ): ProductLocalDataSource {
        return ProductLocalDataSource(dao)
    }
}