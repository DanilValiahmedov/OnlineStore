package com.valimade.onlinestore.data.db

import com.j256.ormlite.dao.Dao

class ProductLocalDataSource(
    private val dao: Dao<ProductEntity, Int>
) {

    fun insertProducts(list: List<ProductEntity>) {
        dao.callBatchTasks {
            list.forEach { dao.createOrUpdate(it) }
        }
    }

    fun getProducts(): List<ProductEntity> {
        return dao.queryForAll()
    }
}
