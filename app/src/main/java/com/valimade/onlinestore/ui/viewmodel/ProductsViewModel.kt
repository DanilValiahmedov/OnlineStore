package com.valimade.onlinestore.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.valimade.onlinestore.domain.model.Product
import com.valimade.onlinestore.domain.usecase.GetProductsFromDbUseCase
import com.valimade.onlinestore.domain.usecase.GetProductsUseCase
import com.valimade.onlinestore.ui.model.ProductsState
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProductsViewModel(
    private val getProductsUseCase: GetProductsUseCase,
    private val getProductsFromDbUseCase: GetProductsFromDbUseCase,
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _state = MutableStateFlow(ProductsState())
    val state = _state.asStateFlow()

    init {
        loadProducts()
    }

    private fun loadProducts() {
        getProductsFromDbUseCase()
            .flatMap { products ->
                if (products.isNotEmpty()) {
                    Single.just(products)
                } else {
                    getProductsUseCase()
                }
            }
            .let(::executeLoading)
    }

    fun reloadFromServer() {
        executeLoading(getProductsUseCase())
    }

    private fun executeLoading(single: Single<List<Product>>) {
        single.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                _state.update { it.copy(isLoading = true, error = null) }
            }
            .subscribe({ products ->
                _state.value = ProductsState(
                    isLoading = false,
                    products = products
                )
            }, { error ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        error = error.localizedMessage ?: "Unknown error"
                    )
                }
            })
            .let { disposables.add(it) }
    }

    override fun onCleared() {
        disposables.clear()
    }
}

