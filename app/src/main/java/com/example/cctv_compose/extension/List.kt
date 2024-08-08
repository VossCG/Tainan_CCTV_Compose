package com.example.cctv_compose.extension

import com.voss.tainan_cctv.model.CCTVDto
import com.voss.tainan_cctv.model.CCTVVo
import com.voss.tainan_cctv.model.Coordinate
import com.voss.tainan_cctv.utils.CCTVUtils

fun List<CCTVDto>.sortByLocationDto(coordinate: Coordinate): List<CCTVDto> {
    return this.sortedBy {
        CCTVUtils.haversine(
            coordinate.latitude,
            coordinate.longitude,
            it.latitude.toDouble(),
            it.longitude.toDouble()
        )
    }
}

fun List<CCTVVo>.sortByLocationVo(coordinate: Coordinate): List<CCTVVo> {
    return this.sortedBy {
        CCTVUtils.haversine(
            coordinate.latitude,
            coordinate.longitude,
            it.latitude.toDouble(),
            it.longitude.toDouble()
        )
    }
}