package com.valimade.onlinestore.product.di.module

import com.valimade.onlinestore.product.domain.repository.ProductRepository
import com.valimade.onlinestore.product.domain.usecase.GetProductsUseCase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UseCaseModule {

    @Provides
    @Singleton
    fun provideGetProductsUseCase(repository: ProductRepository): GetProductsUseCase {
        return GetProductsUseCase(repository)
    }
}