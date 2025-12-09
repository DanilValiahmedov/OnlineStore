package com.valimade.onlinestore.di.module

import com.valimade.onlinestore.domain.repository.ProductRepository
import com.valimade.onlinestore.domain.usecase.GetProductsOrmUseCase
import com.valimade.onlinestore.domain.usecase.GetProductsUseCase
import com.valimade.onlinestore.domain.usecase.SaveProductsToOrmUseCase
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
    fun provideGetProductsOrmUseCase(repository: ProductRepository): GetProductsOrmUseCase {
        return GetProductsOrmUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideSaveProductsToOrmUseCase(repository: ProductRepository): SaveProductsToOrmUseCase {
        return SaveProductsToOrmUseCase(repository)
    }

}