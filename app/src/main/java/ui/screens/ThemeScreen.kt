package com.example.lab.ui.screens.data

import androidx.compose.material3.*
import androidx.compose.runtime.*
import com.example.lab.ui.viewmodel.ThemeViewModel
import androidx.compose.foundation.layout.Column

@Composable
fun ThemeScreen(themeViewModel: ThemeViewModel) {

    val isDark = themeViewModel.isDarkMode.collectAsState().value

    Column {
        Text("Seleccionar tema")
        Switch(
            checked = isDark,
            onCheckedChange = { themeViewModel.toggleTheme() }
        )
    }
}
