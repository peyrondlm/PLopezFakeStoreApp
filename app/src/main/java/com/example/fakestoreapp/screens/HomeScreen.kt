package com.example.fakestoreapp.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.fakestoreapp.services.ProductService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.fakestoreapp.components.ProductCard
import com.example.fakestoreapp.models.ProductViewModel
import com.example.fakestoreapp.ui.theme.ProductDetailScreenRoute

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ProductViewModel
) {
    var loading by remember { mutableStateOf(true) }

    LaunchedEffect(true) {
        try {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://fakestoreapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(ProductService::class.java)
            val result = async(Dispatchers.IO) { service.getAllProducts() }
            val products = result.await()

            viewModel.updateProducts(products)
            loading = false
        } catch (e: Exception) {
            loading = false
            Log.e("HomeScreen", e.toString())
        }
    }

    if (loading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(viewModel.products) { product ->
                ProductCard(
                    product = product,
                    onClick = {
                        navController.navigate(ProductDetailScreenRoute(id = product.id))
                    }
                )
            }
        }
    }
}