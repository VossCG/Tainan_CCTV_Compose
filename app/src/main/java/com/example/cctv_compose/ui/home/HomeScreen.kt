package com.example.cctv_compose.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cctv_compose.ui.components.CCTVView
import com.example.cctv_compose.ui.theme.AppTheme
import com.voss.tainan_cctv.model.CCTVDto


@Composable
fun HomeScreen() {
    Surface {
        Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
            HomeToolbar()
            CCTVView(
                title = CCTVDto.Test.name,
                url = CCTVDto.Test.url,
                Modifier.weight(1f)
            )
            CCTVView(
                title = CCTVDto.Test.name,
                url = CCTVDto.Test.url,
                Modifier.weight(1f)
            )
            CCTVView(
                title = CCTVDto.Test.name,
                url = CCTVDto.Test.url,
                Modifier.weight(1f)
            )
        }
    }
}

@Preview
@Composable
fun Home_Preview() {
    AppTheme(darkTheme = true) {
        HomeScreen()
    }
}