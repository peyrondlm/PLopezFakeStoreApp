package com.example.fakestoreapp.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil3.compose.AsyncImage
import com.example.fakestoreapp.components.ProductCard
import com.example.fakestoreapp.models.ProductViewModel
import com.example.fakestoreapp.ui.theme.Background
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Background),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Background),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Row (
                    modifier = Modifier
                        .padding(top = 25.dp, bottom = 8.dp, start = 15.dp, end = 15.dp)
                        .fillMaxWidth()
                        .height(40.dp),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Mamesco's Store",
                        style = MaterialTheme.typography.titleLarge
                    )
                    AsyncImage(
                        model = "https://res.cloudinary.com/ddfg5b0z1/image/upload/v1759812323/dadonesar_uwsco4.png",
                        contentDescription = null,
                        contentScale = ContentScale.Fit
                    )
                }

            }
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