package com.example.lab.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(
    onNavigate: (String) -> Unit,
    onNavigateToAnimation: () -> Unit, // nuevo parámetro para ir al laboratorio
    onNavigateToProducts: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título: se adapta al tema y accesibilidad
            Text(
                text = "Tienda - Pantalla Principal",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Botón para navegar a la segunda pantalla
            Button(
                onClick = { onNavigate("¡Bienvenido a la tienda! Aquí está tu producto.") }
            ) {
                Text(text = "Ir a la segunda pantalla")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Botón para navegar al laboratorio de animación
            Button(
                onClick = { onNavigateToAnimation() }
            ) {
                Text(text = "Ir al Laboratorio de Animación")
            }
            Button(onClick = onNavigateToProducts) {
                Text("Ver productos")
            }
        }
    }
}
