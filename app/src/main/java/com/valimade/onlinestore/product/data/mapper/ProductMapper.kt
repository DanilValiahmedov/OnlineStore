package com.valimade.onlinestore.product.data.mapper

import com.valimade.onlinestore.product.data.model.DimensionsDto
import com.valimade.onlinestore.product.data.model.ProductDto
import com.valimade.onlinestore.product.data.model.ReviewDto
import com.valimade.onlinestore.product.domain.model.Dimensions
import com.valimade.onlinestore.product.domain.model.Product
import com.valimade.onlinestore.product.domain.model.Review

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

