package com.valimade.onlinestore.data.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products: List<ProductEntityRoom>)

    @Query("SELECT * FROM products_room")
    fun getProducts(): List<ProductEntityRoom>
}