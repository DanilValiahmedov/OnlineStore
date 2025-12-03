package com.valimade.onlinestore.data.api

import com.valimade.onlinestore.data.dto.ProductsResponseDto
import io.reactivex.Single
import retrofit2.http.GET

interface ProductApi {
    @GET("products")
    fun getProducts(): Single<ProductsResponseDto>
}