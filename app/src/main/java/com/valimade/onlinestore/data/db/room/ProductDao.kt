package com.valimade.onlinestore.data.db.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.valimade.onlinestore.data.db.orm.ProductEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProducts(products: List<ProductEntity>)

    @Query("SELECT * FROM products")
    fun getProducts(): List<ProductEntity>
}