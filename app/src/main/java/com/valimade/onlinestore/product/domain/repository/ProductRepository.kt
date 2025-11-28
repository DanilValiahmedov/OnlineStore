package com.valimade.onlinestore.product.domain.repository

import com.valimade.onlinestore.product.domain.model.Product
import io.reactivex.Single

interface ProductRepository {
    fun getProducts(): Single<List<Product>>
}