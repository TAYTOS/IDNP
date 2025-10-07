package com.example.lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import com.example.lab.ui.screens.FormScreen
import com.example.lab.ui.theme.LabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LabTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    FormScreen()
                }
            }
        }
    }
}
