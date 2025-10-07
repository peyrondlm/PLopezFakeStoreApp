package com.example.fakestoreapp.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.fakestoreapp.models.ProductViewModel
import com.example.fakestoreapp.ui.theme.Background
import com.example.fakestoreapp.ui.theme.Primary
import com.example.fakestoreapp.ui.theme.TextPrimary
import com.example.fakestoreapp.ui.theme.TextSecondary

@Composable
fun ProductDetailScreen(
    id: Int,
    viewModel: ProductViewModel
) {
    val product = viewModel.getProductById(id)

    if (product == null) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Background),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Producto no encontrado",
                style = MaterialTheme.typography.titleLarge,
                color = TextPrimary
            )
            Text(
                text = ":( \n Intenta de nuevo",
                style = MaterialTheme.typography.headlineSmall,
                color = TextSecondary,
                textAlign = TextAlign.Center
            )
        }
    } else {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .background(Background)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(bottomStart = 90.dp))
                    .background(Primary)
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    modifier = Modifier
                        .size(190.dp)
                )
                Row (
                    modifier = Modifier
                        .height(15.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    AsyncImage(
                        model = "https://uxwing.com/wp-content/themes/uxwing/download/arts-graphic-shapes/star-white-icon.png",
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(end = 8.dp)
                    )
                    Text(
                        text = "${product.rating.rate} / ${product.category}",
                        color = Color.White,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
            Column (
                modifier = Modifier
                    .weight(2f)
                    .padding(30.dp),
                horizontalAlignment = Alignment.End
            ){
                Text(
                    text = product.title,
                    color = TextPrimary,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.End
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Description: ${product.description}",
                    color = TextSecondary,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.End
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Price: $${product.price}",
                    fontWeight = FontWeight.Thin,
                    style = MaterialTheme.typography.titleMedium,
                    color = TextSecondary,
                    textAlign = TextAlign.End
                )
            }
        }
    }
}
