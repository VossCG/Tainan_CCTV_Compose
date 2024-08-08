package com.example.cctv_compose.model

sealed class UiState<out T> {
    data class Success<out T>(val data: T) : UiState<T>()
    data class Error(val exception: Throwable) : UiState<Nothing>()
    object Loading : UiState<Nothing>()
}