package com.example.fakestoreapp.models

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ProductViewModel : ViewModel() {
    var products by mutableStateOf<List<Product>>(emptyList())
        private set

    fun updateProducts(newProducts: List<Product>) {
        products = newProducts
    }

    fun getProductById(id: Int): Product? {
        return products.find { it.id == id }
    }
}
