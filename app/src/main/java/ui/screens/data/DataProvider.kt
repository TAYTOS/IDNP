package com.example.lab.ui.screens.data

fun generateProductList(): List<Product> {
    return List(20) { index ->
        Product(
            id = index.toString(),
            cui = "2025${index + 10}",
            name = "Producto $index",
            lastname = "Marca ${(65 + index).toChar()}",
            avatarUrl = "https://picsum.photos/200?random=$index"
        )
    }
}
