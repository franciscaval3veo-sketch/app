package com.example.legalmediahub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.legalmediahub.ui.AudioScreen
import com.example.legalmediahub.ui.DownloadScreen
import com.example.legalmediahub.ui.PdfEditorScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

private data class TopLevelRoute(val route: String, val label: String)

@Composable
private fun App() {
    val navController = rememberNavController()
    val routes = listOf(
        TopLevelRoute("download", "Descargas"),
        TopLevelRoute("audio", "MP3"),
        TopLevelRoute("pdf", "PDF")
    )

    Scaffold(
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination

                routes.forEach { topRoute ->
                    val selected = currentDestination?.hierarchy?.any { it.route == topRoute.route } == true
                    NavigationBarItem(
                        selected = selected,
                        onClick = {
                            navController.navigate(topRoute.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(topRoute.label) },
                        icon = {}
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "download",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("download") { DownloadScreen() }
            composable("audio") { AudioScreen() }
            composable("pdf") { PdfEditorScreen() }
        }
    }
}
