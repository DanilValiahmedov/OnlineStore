package com.valimade.onlinestore.data.db.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products_room")
data class ProductEntityRoom(
    @PrimaryKey
    val id: Int,

    val title: String?,
    val description: String?,
    val category: String?,
    val price: Double,
    val rating: Double,
    val thumbnail: String?
)