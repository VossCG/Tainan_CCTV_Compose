package com.example.cctv_compose.ui.cctv

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.voss.tainan_cctv.model.CCTVDto
import com.voss.tainan_cctv.remote.CCTVClient
import com.example.cctv_compose.model.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CCTVViewModel : ViewModel() {
    private val _cctvResult = MutableStateFlow<UiState<List<CCTVDto>>>(UiState.Loading)
    val cctvResult: StateFlow<UiState<List<CCTVDto>>> = _cctvResult.asStateFlow()

    init {
        fetchCCTV()
    }

    private fun fetchCCTV() {
        viewModelScope.launch(Dispatchers.IO) {
            _cctvResult.value = UiState.Loading
            try {
                val data = CCTVClient.API.getCCTVs()
                _cctvResult.value = UiState.Success(data)
            } catch (e: Exception) {
                _cctvResult.value = UiState.Error(e)
            }
        }
    }
}