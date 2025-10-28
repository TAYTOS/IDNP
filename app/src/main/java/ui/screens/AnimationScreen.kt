package com.example.lab.ui.screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimationScreen() {
    var expanded by remember { mutableStateOf(false) }

    // Animación del tamaño del círculo
    val circleSize by animateDpAsState(targetValue = if (expanded) 200.dp else 80.dp)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(modifier = Modifier.size(circleSize)) {
            drawCircle(color = Color(0xFF6200EE))
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { expanded = !expanded }) {
            Text(text = if (expanded) "Reducir círculo" else "Expandir círculo")
        }
    }
}
