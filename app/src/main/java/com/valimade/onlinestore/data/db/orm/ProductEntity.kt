package com.valimade.onlinestore.data.db.orm

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
    val rating: Double = 0.0,

    @DatabaseField
    val thumbnail: String? = null,
)
