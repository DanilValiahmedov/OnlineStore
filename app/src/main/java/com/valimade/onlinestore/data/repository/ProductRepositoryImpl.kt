package com.valimade.onlinestore.data.repository

import com.valimade.onlinestore.data.api.ProductApi
import com.valimade.onlinestore.data.mapper.toDomain
import com.valimade.onlinestore.domain.model.Product
import com.valimade.onlinestore.domain.repository.ProductRepository
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