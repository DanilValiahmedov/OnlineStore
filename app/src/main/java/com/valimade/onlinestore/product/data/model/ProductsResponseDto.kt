package com.valimade.onlinestore.product.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponseDto(
    @SerialName("products")
    val products: List<ProductDto>
)