package com.example.cctv_compose

import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.cctv_compose.ui.cctv.CCTVViewModel
import com.example.cctv_compose.ui.components.navigation.BottomNavGraph
import com.example.cctv_compose.ui.components.navigation.BottomNavigationBar

import com.example.cctv_compose.ui.theme.AppTheme
import com.voss.tainan_cctv.model.Coordinate


@Composable
fun MainScreen(
    cctvViewModel: CCTVViewModel = viewModel(),
) {
    val navController = rememberNavController()

    RequestLocationPermission {
        cctvViewModel.refreshCurrentLocation()
    }

    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        BottomNavGraph(navController = navController, innerPadding = innerPadding)
    }
}

@Composable
fun RequestLocationPermission(onPermissionGranted: () -> Unit) {
    val context = LocalContext.current
    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            onPermissionGranted()
        } else {
            Toast.makeText(context, "need Location permission", Toast.LENGTH_SHORT).show()
        }
    }
    LaunchedEffect(Unit) {
        requestPermissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun MainView_preview() {
    AppTheme(darkTheme = true) {
        MainScreen()
    }
}