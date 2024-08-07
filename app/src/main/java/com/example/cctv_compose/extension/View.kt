package com.example.cctv_compose.extension

import android.webkit.WebView
import com.voss.tainan_cctv.utils.CCTVUtils

fun WebView.loadCCTVUrl(url: String) {
    this.loadData(
        CCTVUtils.getHtmlContent(url),
        "text/html",
        "UTF-8"
    )
}