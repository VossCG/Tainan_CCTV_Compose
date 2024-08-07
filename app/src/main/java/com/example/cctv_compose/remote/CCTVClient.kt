package com.voss.tainan_cctv.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CCTVClient {
    companion object {
        const val BASEURL = "https://tntcc.tainan.gov.tw/"

        private val manager = CCTVClient()
        val API: CCTVService = manager.retrofit.create(CCTVService::class.java)
    }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASEURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}