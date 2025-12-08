package com.valimade.onlinestore.di.module

import com.valimade.onlinestore.domain.repository.ProductRepository
import com.valimade.onlinestore.domain.usecase.GetProductsFromDbUseCase
import com.valimade.onlinestore.domain.usecase.GetProductsUseCase
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

    @Provides
    @Singleton
    fun provideGetProductsFromDbUseCase(repository: ProductRepository): GetProductsFromDbUseCase {
        return GetProductsFromDbUseCase(repository)
    }
}