package com.example.lab.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.lab.ui.screens.FirstScreen
import com.example.lab.ui.screens.SecondScreen
import com.example.lab.ui.screens.AnimationScreen
import com.example.lab.ui.screens.ProductListScreen
import com.example.lab.ui.screens.ProductDetailScreen

@Composable
fun NavGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = "first"
    ) {

        // ✅ Pantalla inicial
        composable("first") {
            FirstScreen(
                onNavigate = { message ->
                    navController.navigate("second/$message")
                },
                onNavigateToAnimation = {
                    navController.navigate("animation")
                },
                onNavigateToProducts = {
                    navController.navigate("products")
                }
            )
        }

        // ✅ Pantalla que recibe mensaje de FirstScreen
        composable(
            route = "second/{message}",
            arguments = listOf(
                navArgument("message") { defaultValue = "Sin datos" }
            )
        ) { backStackEntry ->
            val message = backStackEntry.arguments?.getString("message")
            SecondScreen(
                message = message ?: "Sin datos",
                onBack = { navController.navigateUp() }
            )
        }

        // ✅ Laboratorio de animación
        composable("animation") {
            AnimationScreen()
        }

        // ✅ Lista dinámica de productos
        composable("products") {
            ProductListScreen(
                onProductSelected = { id ->
                    navController.navigate("productDetail/$id")
                }
            )
        }

        // ✅ Pantalla de detalle con parámetro dinámico
        composable(
            route = "productDetail/{productId}",
            arguments = listOf(
                navArgument("productId") { defaultValue = "" }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("productId")
            ProductDetailScreen(
                productId = id,
                onBack = { navController.navigateUp() }
            )
        }
    }
}
