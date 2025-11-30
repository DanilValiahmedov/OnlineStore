package com.valimade.onlinestore.product.domain.usecase

import com.valimade.onlinestore.product.domain.model.Product
import com.valimade.onlinestore.product.domain.repository.ProductRepository
import io.reactivex.Single

class GetProductsUseCase(
    private val repository: ProductRepository
) {
    operator fun invoke(): Single<List<Product>> = repository.getProducts()
}