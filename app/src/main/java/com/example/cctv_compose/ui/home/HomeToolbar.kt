package com.example.cctv_compose.ui.home

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cctv_compose.R
import com.example.cctv_compose.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeToolbar(
    modifier: Modifier = Modifier,
    onRefreshClick: () -> Unit = {},
    onMyLocationClick: () -> Unit = {},
    onChangeLocationClick: () -> Unit = {},
) {
    TopAppBar(
        modifier = modifier,
        title = {
            Text(text = "我的位置")
        },
        actions = {
            IconButton(onClick = onChangeLocationClick) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_location_searching_24),
                    contentDescription = null
                )
            }
            IconButton(onClick = onMyLocationClick) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_my_location_24),
                    contentDescription = null
                )
            }
            IconButton(onClick = onRefreshClick) {
                Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
            }
        })
}

@Preview
@Composable
fun HomeToolbar_Preview() {
    AppTheme {
        HomeToolbar()
    }
}

