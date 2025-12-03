package com.valimade.onlinestore.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDto(

    // Уникальный идентификатор товара
    @SerialName("id")
    val id: Int,

    // Название товара
    @SerialName("title")
    val title: String,

    // Описание товара
    @SerialName("description")
    val description: String,

    // Категория (beauty, groceries, smartphones и т.д.)
    @SerialName("category")
    val category: String,

    // Цена товара
    @SerialName("price")
    val price: Double,

    // Скидка в процентах
    @SerialName("discountPercentage")
    val discountPercentage: Double,

    // Средний рейтинг пользователей
    @SerialName("rating")
    val rating: Double,

    // Количество товара на складе
    @SerialName("stock")
    val stock: Int,

    // Теги товара (массив строк)
    @SerialName("tags")
    val tags: List<String> = emptyList(),

    // Бренд
    @SerialName("brand")
    val brand: String? = null,

    // SKU — уникальный код товара
    @SerialName("sku")
    val sku: String,

    // Вес товара
    @SerialName("weight")
    val weight: Int,

    // Объект с габаритами
    @SerialName("dimensions")
    val dimensions: DimensionsDto,

    // Информация о гарантии
    @SerialName("warrantyInformation")
    val warrantyInformation: String? = null,

    // Информация о доставке
    @SerialName("shippingInformation")
    val shippingInformation: String? = null,

    // Статус доступности (In Stock, Out of Stock и т.д.)
    @SerialName("availabilityStatus")
    val availabilityStatus: String,

    // Список отзывов
    @SerialName("reviews")
    val reviews: List<ReviewDto> = emptyList(),

    // Политика возврата
    @SerialName("returnPolicy")
    val returnPolicy: String? = null,

    // Минимальное количество, которое можно заказать
    @SerialName("minimumOrderQuantity")
    val minimumOrderQuantity: Int,

    // Полный список изображений товара
    @SerialName("images")
    val images: List<String> = emptyList(),

    // Миниатюра (thumbnail)
    @SerialName("thumbnail")
    val thumbnail: String
)

@Serializable
data class DimensionsDto(
    @SerialName("width") val width: Double,
    @SerialName("height") val height: Double,
    @SerialName("depth") val depth: Double
)

@Serializable
data class ReviewDto(
    // Оценка отзыва
    @SerialName("rating") val rating: Int,

    // Комментарий пользователя
    @SerialName("comment") val comment: String,

    // Дата отзыва в ISO формате
    @SerialName("date") val date: String,

    // Имя автора
    @SerialName("reviewerName") val reviewerName: String,

    // Email автора
    @SerialName("reviewerEmail") val reviewerEmail: String
)
