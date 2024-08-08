package com.example.cctv_compose.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import com.example.cctv_compose.model.UiState
import com.example.cctv_compose.ui.components.CCTVView


@Composable
fun HomeScreen(
    cctvViewModel: CCTVViewModel = viewModel(),
) {

    val uiState = cctvViewModel.cctvResult.collectAsState()

    Surface {
        when (val state = uiState.value) {
            is UiState.Error -> {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text(text = state.exception.message.toString())
                }
            }

            is UiState.Loading -> {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    CircularProgressIndicator(
                        modifier = Modifier.width(64.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        trackColor = MaterialTheme.colorScheme.surfaceVariant,
                    )
                }
            }

            is UiState.Success -> {
                val cctvList = state.data.take(3)
                Column(verticalArrangement = Arrangement.spacedBy(0.dp)) {
                    HomeToolbar()
                    CCTVView(
                        title = cctvList[0].name,
                        url = cctvList[0].url,
                        modifier = Modifier.weight(1f)
                    )
                    CCTVView(
                        title = cctvList[1].name,
                        url = cctvList[1].url,
                        modifier = Modifier.weight(1f)
                    )
                    CCTVView(
                        title = cctvList[2].name,
                        url = cctvList[2].url,
                        modifier = Modifier.weight(1f)
                    )
                }
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