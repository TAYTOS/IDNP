package com.example.lab.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(onNavigate: (String) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Título: usa MaterialTheme.typography -> respeta font scale del sistema
            Text(
                text = "Tienda - Pantalla Principal",
                style = MaterialTheme.typography.headlineSmall, // escalable
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { onNavigate("¡Bienvenido a la tienda! Aquí está tu producto.") }
            ) {
                Text(text = "Ir a la segunda pantalla")
            }
        }
    }
}
