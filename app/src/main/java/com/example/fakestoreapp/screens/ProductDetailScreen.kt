package com.example.fakestoreapp.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.fakestoreapp.models.ProductViewModel

@Composable
fun ProductDetailScreen(
    id: Int,
    viewModel: ProductViewModel
) {
    val product = viewModel.getProductById(id)

    if (product == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Producto no encontrado")
        }
    } else {
        // Muestra la información del producto
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("${product.title}\n\n${product.description}")
        }
    }
}
