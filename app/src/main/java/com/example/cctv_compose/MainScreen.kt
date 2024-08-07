package com.example.cctv_compose

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.cctv_compose.ui.navigation.BottomNavGraph
import com.example.cctv_compose.ui.navigation.BottomNavigationBar

import com.example.cctv_compose.ui.theme.AppTheme


@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController = navController) }
    ) { innerPadding ->
        BottomNavGraph(navController = navController, innerPadding = innerPadding)
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun MainView_preview() {
    AppTheme(darkTheme = true) {
        MainScreen()
    }
}