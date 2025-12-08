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

    // Средний рейтинг пользователей
    @SerialName("rating")
    val rating: Double,

    // Миниатюра (thumbnail)
    @SerialName("thumbnail")
    val thumbnail: String
)
