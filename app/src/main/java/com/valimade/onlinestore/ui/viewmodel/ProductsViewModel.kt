package com.valimade.onlinestore.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.valimade.onlinestore.domain.usecase.GetProductsUseCase
import com.valimade.onlinestore.ui.model.ProductsState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProductsState())
    val state = _state.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        getProductsUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _state.value = ProductsState(isLoading = true)
            }
            .subscribe({ products ->
                _state.value = ProductsState(
                    isLoading = false,
                    products = products
                )
            }, { error ->
                _state.value = ProductsState(
                    isLoading = false,
                    error = error.message
                )
            })
    }
}