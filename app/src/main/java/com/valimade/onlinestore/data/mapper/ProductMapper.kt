package com.valimade.onlinestore.data.mapper

import com.valimade.onlinestore.data.db.ProductEntity
import com.valimade.onlinestore.data.dto.ProductDto
import com.valimade.onlinestore.domain.model.Product

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        category = category,
        price = price,
        rating = rating,
        thumbnail = thumbnail
    )
}


fun ProductDto.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        title = title,
        description = description,
        category = category,
        price = price,
        rating = rating,
        thumbnail = thumbnail
    )
}

fun ProductEntity.toDomain(): Product {
    return Product(
        id = id,
        title = title.orEmpty(),
        description = description.orEmpty(),
        category = category.orEmpty(),
        price = price,
        rating = rating,
        thumbnail = thumbnail.orEmpty()
    )
}


