package com.voss.tainan_cctv.model

import com.google.gson.annotations.SerializedName

data class CCTVDto(
    val id: String,
    val name: String,
    @SerializedName("wgsx")
    val longitude: String,
    @SerializedName("wgsy")
    val latitude: String,
    val url: String,
    val source: String,
    val updateTime: String,
) {

    companion object {
        val Test = CCTVDto(
            id = "C112065",
            name = "裕農路與裕義路口西桿(向東",
            longitude = "120.247553",
            latitude = "22.990596",
            url = "https://trafficvideo3.tainan.gov.tw/aed99d50",
            source = "TNC",
            updateTime = "2024-08-07T16:14:58+08:00"
        )
    }

    fun toCCTVItem(isFavorite: Boolean) = CCTVVo(
        id, name, longitude, latitude, url, source, updateTime, isFavorite
    )
}