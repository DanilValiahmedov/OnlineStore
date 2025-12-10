package com.valimade.onlinestore.domain.usecase

import com.valimade.onlinestore.domain.model.Product
import com.valimade.onlinestore.domain.repository.ProductRepository
import io.reactivex.Single

class SaveProductsToRoomUseCase(
    private val repository: ProductRepository
) {
    operator fun invoke(single: Single<List<Product>>) = repository.saveProductsToRoom(single)
}