package com.example.lab.data.repository

import com.example.lab.data.model.Product

object FakeProductRepository {

    fun getProducts(): List<Product> {
        return List(20) { index ->
            Product(
                id = index + 1,
                name = "Producto $index",
                price = (10..100).random().toDouble(),
                stock = (1..50).random()
            )
        }
    }
}
