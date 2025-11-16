package com.example.lab.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab.data.datastore.ThemePreference
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ThemeViewModel(private val prefs: ThemePreference) : ViewModel() {

    private val _isDarkMode = MutableStateFlow(false)
    val isDarkMode: StateFlow<Boolean> = _isDarkMode

    init {
        viewModelScope.launch {
            prefs.isDarkMode.collect { value ->
                _isDarkMode.value = value
            }
        }
    }

    fun toggleTheme() {
        viewModelScope.launch {
            prefs.saveTheme(!_isDarkMode.value)
        }
    }
}
