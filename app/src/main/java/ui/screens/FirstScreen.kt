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
    onNavigateToAnimation: () -> Unit,
    onNavigateToProducts: () -> Unit,
    onNavigateToTheme: () -> Unit     // <-- AGREGADO
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

            Text(
                text = "Tienda - Pantalla Principal",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { onNavigate("¡Bienvenido a la tienda! Aquí está tu producto.") }
            ) {
                Text("Ir a la segunda pantalla")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onNavigateToAnimation) {
                Text("Ir al Laboratorio de Animación")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onNavigateToProducts) {
                Text("Ver productos")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = onNavigateToTheme) {
                Text("Cambiar Tema")
            }
        }
    }
}
