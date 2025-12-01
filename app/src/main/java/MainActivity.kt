package com.example.lab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.rememberNavController
import androidx.work.*
import com.example.lab.data.datastore.ThemePreference
import com.example.lab.navigation.NavGraph
import com.example.lab.ui.theme.LabTheme
import com.example.lab.ui.viewmodel.ThemeViewModel
import com.example.lab.work.LogWorker  // ← IMPORTANTE

import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 👉 INICIAR WORKMANAGER AQUÍ
        startBackgroundWorker()

        setContent {
            val prefs = ThemePreference(this)
            val themeViewModel = ThemeViewModel(prefs)

            val isDark by themeViewModel.isDarkMode.collectAsState()

            LabTheme(darkTheme = isDark) {
                val navController = rememberNavController()
                NavGraph(
                    navController = navController,
                    themeViewModel = themeViewModel
                )
            }
        }
    }

    private fun startBackgroundWorker() {
        val workRequest = PeriodicWorkRequestBuilder<LogWorker>(
            15, TimeUnit.MINUTES
        ).build()

        WorkManager.getInstance(this)
            .enqueueUniquePeriodicWork(
                "LogWorkerTask",
                ExistingPeriodicWorkPolicy.UPDATE,
                workRequest
            )
    }
}
