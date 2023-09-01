package com.example.localapp.models

data class ProductList(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)