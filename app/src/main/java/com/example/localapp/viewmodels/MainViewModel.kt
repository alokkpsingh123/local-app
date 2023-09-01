package com.example.localapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.localapp.models.Product
import com.example.localapp.models.ProductList
import com.example.localapp.repository.ProductRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) :ViewModel() {

    val productsLiveData : LiveData<ProductList>
        get() = repository.products

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getProducts()
        }
    }
}