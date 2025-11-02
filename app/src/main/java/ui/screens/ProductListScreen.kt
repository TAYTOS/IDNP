package com.example.lab.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.lab.ui.screens.data.*

@Composable
fun ProductListScreen(
    onProductSelected: (String) -> Unit
) {
    val productList = generateProductList()

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(16.dp)
        ) {
            items(productList) { product ->
                ProductCard(product, onProductSelected)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun ProductCard(product: Product, onProductSelected: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clickable { onProductSelected(product.id) } // 👈 ahora navega al detalle
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberAsyncImagePainter(model = product.avatarUrl),
                contentDescription = "Avatar",
                modifier = Modifier.size(60.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(text = "CUI: ${product.cui}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Nombre: ${product.name}")
                Text(text = "Apellido: ${product.lastname}")
            }
        }
    }
}
