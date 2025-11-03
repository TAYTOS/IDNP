package com.example.lab.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.lab.data.model.Product
import com.example.lab.ui.viewmodel.ProductViewModel

@Composable
fun ProductListScreen(
    onProductSelected: (Int) -> Unit,
    productViewModel: ProductViewModel = viewModel()
) {
    val products = productViewModel.products.collectAsState().value

    LazyColumn(modifier = Modifier.padding(16.dp)) {
        items(products) { product ->
            ProductCard(
                product = product,
                onClick = { onProductSelected(product.id) }
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "ID: ${product.id}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Nombre: ${product.name}")
            Text(text = "Stock: ${product.stock}")
        }
    }
}
