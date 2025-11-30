package com.valimade.onlinestore.product.di.module

import com.valimade.onlinestore.product.data.api.ProductApi
import com.valimade.onlinestore.product.data.repository.ProductRepositoryImpl
import com.valimade.onlinestore.product.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideProductRepository(api: ProductApi): ProductRepository {
        return ProductRepositoryImpl(api)
    }
}