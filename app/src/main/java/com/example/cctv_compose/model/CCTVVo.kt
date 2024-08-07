package com.voss.tainan_cctv.model

data class CCTVVo(
    val id: String,
    val name: String,
    val longitude: String,
    val latitude: String,
    val url: String,
    val source: String,
    val updateTime: String,
    val isFavorite: Boolean,
) {
    fun getLonLatText(): String {
        return "經度: $longitude , 緯度: $latitude"
    }
    fun toCCTV() = CCTVDto(id, name, longitude, latitude, url, source, updateTime)
}