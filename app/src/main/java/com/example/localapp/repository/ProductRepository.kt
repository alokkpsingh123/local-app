package com.example.localapp.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.localapp.models.Product
import com.example.localapp.models.ProductList
import com.example.localapp.retrofit.ProductAPI
import javax.inject.Inject

//Constructor Injection
class ProductRepository @Inject constructor(private val productAPI: ProductAPI){
    private val  _products = MutableLiveData<ProductList>()
    val products: LiveData<ProductList>
        get() = _products

    suspend fun getProducts(){
        val result = productAPI.getProducts()

        if(result?.body() !=null){
            _products.postValue(result.body())
        }
    }
}