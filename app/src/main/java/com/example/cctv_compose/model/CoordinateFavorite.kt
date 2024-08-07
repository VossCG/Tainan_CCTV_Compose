package com.voss.tainan_cctv.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coordinate_favorite")
data class CoordinateFavorite(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val latitude: Double,
    val longitude: Double,
) {
    fun getLonLatText(): String {
        return "經度: $longitude , 緯度: $latitude"
    }

    fun toCoordinate() = Coordinate(latitude, longitude)
}