package com.valimade.onlinestore.domain.repository

import com.valimade.onlinestore.domain.model.Product
import io.reactivex.Single

interface ProductRepository {
    fun getProducts(): Single<List<Product>>
    fun getProductsFromOrm(): Single<List<Product>>
    fun saveProductsToOrm(single: Single<List<Product>>)
}