package com.example.lab.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lab.ui.screens.FirstScreen
import com.example.lab.ui.screens.SecondScreen
import com.example.lab.ui.screens.AnimationScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "first") {

        // Pantalla inicial
        composable("first") {
            FirstScreen(onNavigate = { message ->
                navController.navigate("second/${message}")
            },
                onNavigateToAnimation = {   // Nuevo parámetro para ir al laboratorio
                    navController.navigate("animation")
                })
        }

        // Pantalla que recibe mensaje
        composable("second/{message}") { backStackEntry ->
            val message = backStackEntry.arguments?.getString("message") ?: "Sin datos"
            SecondScreen(message = message, onBack = { navController.navigateUp() })
        }

        // Nueva pantalla del laboratorio (círculo animado)
        composable("animation") {
            AnimationScreen()
        }
    }
}
