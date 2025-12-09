package com.valimade.onlinestore.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.valimade.onlinestore.domain.usecase.GetProductsOrmUseCase
import com.valimade.onlinestore.domain.usecase.GetProductsUseCase
import javax.inject.Inject

class ProductsViewModelFactory @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductsOrmUseCase: GetProductsOrmUseCase,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProductsViewModel::class.java)) {
            return ProductsViewModel(getProductsUseCase, getProductsOrmUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}