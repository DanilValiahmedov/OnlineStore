package com.valimade.onlinestore.di.module

import com.valimade.onlinestore.domain.usecase.GetProductsOrmUseCase
import com.valimade.onlinestore.domain.usecase.GetProductsUseCase
import com.valimade.onlinestore.domain.usecase.SaveProductsToOrmUseCase
import com.valimade.onlinestore.ui.viewmodel.ProductsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideProductsViewModelFactory(
        getProductsUseCase: GetProductsUseCase,
        getProductsOrmUseCase: GetProductsOrmUseCase,
        saveProductsToOrmUseCase: SaveProductsToOrmUseCase,
    ): ProductsViewModelFactory {
        return ProductsViewModelFactory(getProductsUseCase, getProductsOrmUseCase, saveProductsToOrmUseCase)
    }
}