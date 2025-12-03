package com.valimade.onlinestore.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductsResponseDto(
    @SerialName("products")
    val products: List<ProductDto>
)