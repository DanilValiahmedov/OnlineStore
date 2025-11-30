package com.valimade.onlinestore.product.data.repository

import com.valimade.onlinestore.product.data.api.ProductApi
import com.valimade.onlinestore.product.data.mapper.toDomain
import com.valimade.onlinestore.product.domain.model.Product
import com.valimade.onlinestore.product.domain.repository.ProductRepository
import io.reactivex.Single

class ProductRepositoryImpl(
    private val api: ProductApi
) : ProductRepository {

    override fun getProducts(): Single<List<Product>> {
        return api.getProducts()
            .map { response -> response.products }
            .map { dtoList -> dtoList.map { it.toDomain() } }
    }
}