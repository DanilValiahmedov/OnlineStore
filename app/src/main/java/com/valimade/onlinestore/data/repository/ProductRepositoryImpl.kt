package com.valimade.onlinestore.data.repository

import com.valimade.onlinestore.data.api.ProductApi
import com.valimade.onlinestore.data.db.ProductEntity
import com.valimade.onlinestore.data.db.ProductLocalDataSource
import com.valimade.onlinestore.data.mapper.toDomain
import com.valimade.onlinestore.data.mapper.toEntity
import com.valimade.onlinestore.domain.model.Product
import com.valimade.onlinestore.domain.repository.ProductRepository
import io.reactivex.Single

class ProductRepositoryImpl(
    private val api: ProductApi,
    private val dao: ProductLocalDataSource
) : ProductRepository {

    override fun getProducts(): Single<List<Product>> {
        return api.getProducts()
            .map { response -> response.products }
            .map { dtoList ->
                val entities = dtoList.map { it.toEntity() }
                saveProductsToDb(entities)
                dtoList.map { it.toDomain() }
            }
    }

    override fun getProductsFromDb(): Single<List<Product>> {
        return Single.fromCallable {
            dao.getProducts().map { it.toDomain() }
        }
    }

    private fun saveProductsToDb(products: List<ProductEntity>) {
        dao.insertProducts(products)
    }
}