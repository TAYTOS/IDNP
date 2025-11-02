package com.example.lab.data.repository

import com.example.lab.data.model.Product

object FakeProductRepository {

    fun getProducts(): List<Product> {
        return List(20) { index ->
            Product(
                id = index + 1,
                name = "Producto $index",
                category = "Categoría ${(1..5).random()}",
                avatar = "https://i.pravatar.cc/150?img=${(1..70).random()}"
            )
        }
    }
}