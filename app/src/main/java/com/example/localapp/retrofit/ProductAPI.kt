package com.example.localapp.retrofit

import com.example.localapp.models.Product
import com.example.localapp.models.ProductList
import retrofit2.Response
import retrofit2.http.GET

interface ProductAPI {
   @GET("/products")
   suspend fun getProducts(): Response<ProductList>
}
