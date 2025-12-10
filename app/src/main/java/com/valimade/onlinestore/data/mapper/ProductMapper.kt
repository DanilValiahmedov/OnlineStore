package com.valimade.onlinestore.data.mapper

import com.valimade.onlinestore.data.db.orm.ProductEntity
import com.valimade.onlinestore.data.db.room.ProductEntityRoom
import com.valimade.onlinestore.data.dto.ProductDto
import com.valimade.onlinestore.domain.model.Product
import kotlin.text.orEmpty

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


fun Product.toEntity(): ProductEntity {
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

fun Product.toEntityRoom(): ProductEntityRoom {
    return ProductEntityRoom(
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

fun ProductEntityRoom.toDomain(): Product {
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


