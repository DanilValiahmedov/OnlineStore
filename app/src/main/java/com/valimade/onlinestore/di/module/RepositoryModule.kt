package com.valimade.onlinestore.di.module

import com.valimade.onlinestore.data.api.ProductApi
import com.valimade.onlinestore.data.db.orm.ProductLocalDataSource
import com.valimade.onlinestore.data.db.room.ProductDao
import com.valimade.onlinestore.data.repository.ProductRepositoryImpl
import com.valimade.onlinestore.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(
        api: ProductApi,
        daoOrm: ProductLocalDataSource,
        daoRoom: ProductDao,
    ): ProductRepository {
        return ProductRepositoryImpl(api, daoOrm, daoRoom)
    }
}