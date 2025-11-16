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
import com.example.lab.ui.screens.data.ThemeScreen
import com.example.lab.ui.viewmodel.ThemeViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    themeViewModel: ThemeViewModel
) {

    NavHost(
        navController = navController,
        startDestination = "first"
    ) {

        // 🔵 Pantalla de selección de tema
        composable("theme") {
            ThemeScreen(themeViewModel)
        }

        // 🔵 Pantalla inicial
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
                },
                onNavigateToTheme = {
                    navController.navigate("theme")
                }
            )
        }

        // 🔵 Pantalla que recibe mensaje
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

        // 🔵 Animación
        composable("animation") {
            AnimationScreen()
        }

        // 🔵 Lista de productos
        composable("products") {
            ProductListScreen(
                onProductSelected = { id ->
                    navController.navigate("productDetail/$id")
                }
            )
        }

        // 🔵 Detalle de producto
        composable(
            route = "productDetail/{productId}",
            arguments = listOf(
                navArgument("productId") { defaultValue = "" }
            )
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getString("productId")
            ProductDetailScreen(
                productId = id ?: "",
                onBack = { navController.navigateUp() }
            )
        }
    }
}
