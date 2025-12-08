package com.valimade.onlinestore.data.mapper

import com.valimade.onlinestore.data.db.ProductEntity
import com.valimade.onlinestore.data.dto.DimensionsDto
import com.valimade.onlinestore.data.dto.ProductDto
import com.valimade.onlinestore.data.dto.ReviewDto
import com.valimade.onlinestore.domain.model.Dimensions
import com.valimade.onlinestore.domain.model.Product
import com.valimade.onlinestore.domain.model.Review
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        category = category,
        price = price,
        discountPercentage = discountPercentage,
        rating = rating,
        stock = stock,
        tags = tags,
        brand = brand,
        sku = sku,
        weight = weight,
        dimensions = dimensions.toDomain(),
        warrantyInformation = warrantyInformation,
        shippingInformation = shippingInformation,
        availabilityStatus = availabilityStatus,
        reviews = reviews.map { it.toDomain() },
        returnPolicy = returnPolicy,
        minimumOrderQuantity = minimumOrderQuantity,
        images = images,
        thumbnail = thumbnail
    )
}

fun DimensionsDto.toDomain() = Dimensions(width, height, depth)

fun ReviewDto.toDomain() = Review(rating, comment, date, reviewerName, reviewerEmail)

fun ProductDto.toEntity(): ProductEntity {
    return ProductEntity(
        id = id,
        title = title,
        description = description,
        category = category,
        price = price,
        discountPercentage = discountPercentage,
        rating = rating,
        stock = stock,
        tagsJson = Json.encodeToString(tags),
        brand = brand,
        sku = sku,
        weight = weight,
        dimensionsJson = Json.encodeToString(dimensions),
        warrantyInformation = warrantyInformation,
        shippingInformation = shippingInformation,
        availabilityStatus = availabilityStatus,
        reviewsJson = Json.encodeToString(reviews),
        returnPolicy = returnPolicy,
        minimumOrderQuantity = minimumOrderQuantity,
        imagesJson = Json.encodeToString(images),
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
        discountPercentage = discountPercentage,
        rating = rating,
        stock = stock,
        tags = Json.decodeFromString(tagsJson ?: "[]"),
        brand = brand,
        sku = sku.orEmpty(),
        weight = weight,
        dimensions = Json.decodeFromString(dimensionsJson ?: """{"width":0,"height":0,"depth":0}"""),
        warrantyInformation = warrantyInformation,
        shippingInformation = shippingInformation,
        availabilityStatus = availabilityStatus.orEmpty(),
        reviews = Json.decodeFromString(reviewsJson ?: "[]"),
        returnPolicy = returnPolicy,
        minimumOrderQuantity = minimumOrderQuantity,
        images = Json.decodeFromString(imagesJson ?: "[]"),
        thumbnail = thumbnail.orEmpty()
    )
}


