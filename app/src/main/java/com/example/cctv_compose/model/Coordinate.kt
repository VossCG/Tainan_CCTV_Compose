package com.voss.tainan_cctv.model

data class Coordinate(
    val latitude: Double,
    val longitude: Double,
) {
    companion object {
        val TRAIN_STATION = Coordinate(22.997224345342094, 120.21216780433548)
    }
}