package com.example.cctv_compose.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.cctv_compose.ui.cctv.CCTVViewModel
import com.example.cctv_compose.ui.theme.AppTheme
import com.example.cctv_compose.ui.components.CCTVView
import com.voss.tainan_cctv.model.Coordinate


@Composable
fun HomeScreen(
    cctvViewModel: CCTVViewModel = viewModel(),
) {
    val cctvList = cctvViewModel.nearbyCCTV.collectAsState()

    Surface {
        if (cctvList.value.isEmpty()) {
            Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.width(64.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    strokeWidth = 12.dp,
                )
            }
        } else {
            Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                HomeToolbar(
                    onRefreshClick = {
                        cctvViewModel.refreshCurrentLocation()
                    },
                    onMyLocationClick = {
                        cctvViewModel.setLocation(Coordinate.TRAIN_STATION)
                    }
                )
                CCTVView(
                    title = cctvList.value[0].name,
                    url = cctvList.value[0].url,
                    modifier = Modifier
                        .weight(1f)
                )
                CCTVView(
                    title = cctvList.value[1].name,
                    url = cctvList.value[1].url,
                    modifier = Modifier
                        .weight(1f)
                )
                CCTVView(
                    title = cctvList.value[2].name,
                    url = cctvList.value[2].url,
                    modifier = Modifier
                        .weight(1f)
                )
            }
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