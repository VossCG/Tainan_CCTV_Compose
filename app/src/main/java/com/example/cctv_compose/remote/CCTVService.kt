package com.voss.tainan_cctv.remote

import com.voss.tainan_cctv.model.CCTVDto
import retrofit2.http.GET

interface CCTVService {
    @GET("api/cctvs")
    suspend fun getCCTVs(): List<CCTVDto>
}
