package com.valimade.onlinestore.di.module

import com.valimade.onlinestore.domain.usecase.GetProductsUseCase
import com.valimade.onlinestore.ui.viewmodel.ProductsViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule {

    @Provides
    fun provideProductsViewModelFactory(
        getProductsUseCase: GetProductsUseCase
    ): ProductsViewModelFactory {
        return ProductsViewModelFactory(getProductsUseCase)
    }
}