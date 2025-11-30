package com.valimade.onlinestore.product.data.api

import com.valimade.onlinestore.product.data.model.ProductsResponseDto
import io.reactivex.Single
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    fun getProducts(): Single<ProductsResponseDto>
}