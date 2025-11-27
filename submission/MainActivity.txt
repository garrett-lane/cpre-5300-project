package com.example.cpre5300project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.cpre5300project.navigation.AppNavigation
import com.example.cpre5300project.ui.theme.CPRE5300ProjectTheme

/**
 * This hosts the entire app using Jetpack Compose.
 * It sets up navigation and the app theme.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Edge-to-edge display
        enableEdgeToEdge()

        setContent {
            // Apply the app theme
            CPRE5300ProjectTheme {
                // Create navigation controller for managing screen transitions
                val navController = rememberNavController()

                // Scaffold provides the basic Material Design layout structure
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    // Set up navigation graph with all app screens
                    AppNavigation(
                        navController = navController
                    )
                }
            }
        }
    }
}