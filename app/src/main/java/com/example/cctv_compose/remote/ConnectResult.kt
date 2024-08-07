package com.voss.tainan_cctv.remote

sealed class ConnectResult<out T> {
    data class Success<out T>(val data: T) : ConnectResult<T>()
    data class Error(val exception: Throwable) : ConnectResult<Nothing>()
    object Loading : ConnectResult<Nothing>()
}