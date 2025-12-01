package com.example.lab.work

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import android.util.Log

class LogWorker(appContext: Context, workerParams: WorkerParameters) :
    Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.d("WorkManager", "Ejecutando tarea en segundo plano...")
        return Result.success()
    }
}