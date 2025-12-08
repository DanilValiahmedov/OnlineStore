package com.valimade.onlinestore.data.db

import com.j256.ormlite.field.DatabaseField
import com.j256.ormlite.table.DatabaseTable

@DatabaseTable(tableName = "products")
data class ProductEntity(

    @DatabaseField(id = true)
    val id: Int = 0,

    @DatabaseField
    val title: String? = null,

    @DatabaseField
    val description: String? = null,

    @DatabaseField
    val category: String? = null,

    @DatabaseField
    val price: Double = 0.0,

    @DatabaseField
    val discountPercentage: Double = 0.0,

    @DatabaseField
    val rating: Double = 0.0,

    @DatabaseField
    val stock: Int = 0,

    // Сериализованный список тегов
    @DatabaseField
    val tagsJson: String? = null,

    @DatabaseField
    val brand: String? = null,

    @DatabaseField
    val sku: String? = null,

    @DatabaseField
    val weight: Int = 0,

    // Вложенный объект dimensions в JSON
    @DatabaseField
    val dimensionsJson: String? = null,

    @DatabaseField
    val warrantyInformation: String? = null,

    @DatabaseField
    val shippingInformation: String? = null,

    @DatabaseField
    val availabilityStatus: String? = null,

    // Список отзывов (JSON)
    @DatabaseField
    val reviewsJson: String? = null,

    @DatabaseField
    val returnPolicy: String? = null,

    @DatabaseField
    val minimumOrderQuantity: Int = 0,

    // Список изображений (JSON)
    @DatabaseField
    val imagesJson: String? = null,

    @DatabaseField
    val thumbnail: String? = null,
)
