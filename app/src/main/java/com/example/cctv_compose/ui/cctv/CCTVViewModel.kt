package com.example.cctv_compose.ui.cctv

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.location.Location
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cctv_compose.extension.sortByLocationDto
import com.voss.tainan_cctv.model.CCTVDto
import com.voss.tainan_cctv.remote.CCTVClient
import com.example.cctv_compose.model.UiState
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.voss.tainan_cctv.model.Coordinate
import com.voss.tainan_cctv.utils.CCTVUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CCTVViewModel(application: Application) : AndroidViewModel(application) {
    private val cctvDto = MutableStateFlow<List<CCTVDto>>(emptyList())

    private val fusedLocationClient: FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(application)

    private val userLocation = MutableStateFlow<Coordinate>(Coordinate.TRAIN_STATION)

    val nearbyCCTV: StateFlow<List<CCTVDto>> =
        combine(cctvDto, userLocation) { cctv, userLocation ->
            cctv.sortByLocationDto(userLocation).take(3)
        }.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    @SuppressLint("MissingPermission")
    fun refreshCurrentLocation() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                    location?.let {
                        val latitude = it.latitude
                        val longitude = it.longitude
                        userLocation.value = Coordinate(latitude, longitude)
                    }
                }
            } catch (e: Exception) {
                // Handle exceptions
            }
        }
    }

    init {
        refreshCurrentLocation()
        fetchCCTV()
    }

    private fun fetchCCTV() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val data = CCTVClient.API.getCCTVs()
                cctvDto.value = data
            } catch (e: Exception) {
                cctvDto.value = emptyList()
            }
        }
    }
}