package com.voss.tainan_cctv.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cctv_favorite")
data class CCTVFavorite(
    @PrimaryKey val cctvId: String
)