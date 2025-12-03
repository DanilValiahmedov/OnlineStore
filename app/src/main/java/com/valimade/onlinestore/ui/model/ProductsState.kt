package com.valimade.onlinestore.ui.model

import com.valimade.onlinestore.domain.model.Product

data class ProductsState(
    val isLoading: Boolean = false,
    val products: List<Product> = emptyList(),
    val error: String? = null
)