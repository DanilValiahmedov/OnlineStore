package com.valimade.onlinestore.data.repository

import com.valimade.onlinestore.data.api.ProductApi
import com.valimade.onlinestore.data.db.orm.ProductLocalDataSource
import com.valimade.onlinestore.data.db.room.ProductDao
import com.valimade.onlinestore.data.mapper.toDomain
import com.valimade.onlinestore.data.mapper.toEntity
import com.valimade.onlinestore.data.mapper.toEntityRoom
import com.valimade.onlinestore.domain.model.Product
import com.valimade.onlinestore.domain.repository.ProductRepository
import io.reactivex.Single

class ProductRepositoryImpl(
    private val api: ProductApi,
    private val daoOrm: ProductLocalDataSource,
    private val daoRoom: ProductDao,
) : ProductRepository {

    override fun getProducts(): Single<List<Product>> {
        return api.getProducts()
            .map { response -> response.products }
            .map { dtoList ->
                dtoList.map { it.toDomain() }
            }
    }

    override fun getProductsFromOrm(): Single<List<Product>> {
        return Single.fromCallable {
            daoOrm.getProducts().map { it.toDomain() }
        }
    }

    override fun saveProductsToOrm(single: Single<List<Product>>) {
        single
            .doOnSuccess { products ->
                val entities = products.map { it.toEntity() }
                daoOrm.insertProducts(entities)
            }
            .subscribe()
    }

    override fun getProductsFromRoom(): Single<List<Product>> {
        return Single.fromCallable {
            daoRoom.getProducts().map { it.toDomain() }
        }
    }

    override fun saveProductsToRoom(single: Single<List<Product>>) {
        single
            .doOnSuccess { products ->
                val entities = products.map { it.toEntityRoom() }
                daoRoom.insertProducts(entities)
            }
            .subscribe()
    }

}