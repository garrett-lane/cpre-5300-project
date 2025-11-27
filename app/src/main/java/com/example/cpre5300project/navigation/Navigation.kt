package com.example.cpre5300project.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cpre5300project.data.AppContent
import com.example.cpre5300project.data.PageContent
import com.example.cpre5300project.ui.screens.CompletionScreen
import com.example.cpre5300project.ui.screens.EducationScreen
import com.example.cpre5300project.ui.screens.IntroductionScreen
import com.example.cpre5300project.ui.screens.TestScreen
import com.example.cpre5300project.ui.screens.WelcomeScreen

/**
 * Sets up navigation for the entire app using Jetpack Compose Navigation.
 *
 * @param navController The NavHostController that manages navigation state
 */
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "page_0" // Start at the welcome screen
    ) {
        // Create a composable route for each page in the app
        AppContent.pages.forEachIndexed { index, pageContent ->
            composable("page_$index") {
                // Render the appropriate screen based on the page content type
                when (pageContent) {
                    is PageContent.Welcome -> {
                        WelcomeScreen(
                            content = pageContent,
                            onNext = { navigateToNext(navController, index) }
                        )
                    }
                    is PageContent.Introduction -> {
                        IntroductionScreen(
                            content = pageContent,
                            onNext = { navigateToNext(navController, index) }
                        )
                    }
                    is PageContent.Education -> {
                        EducationScreen(
                            content = pageContent,
                            onNext = { navigateToNext(navController, index) }
                        )
                    }
                    is PageContent.Test -> {
                        TestScreen(
                            content = pageContent,
                            onNext = { navigateToNext(navController, index) }
                        )
                    }
                    is PageContent.Completion -> {
                        // Completion screen has no "next" button - it's the final page
                        CompletionScreen(
                            content = pageContent
                        )
                    }
                }
            }
        }
    }
}

/**
 * Navigates to the next page in the sequence.
 *
 * @param navController The NavHostController to perform navigation
 * @param currentIndex The index of the current page
 */
private fun navigateToNext(navController: NavHostController, currentIndex: Int) {
    val nextIndex = currentIndex + 1
    if (nextIndex < AppContent.pages.size) {
        navController.navigate("page_$nextIndex") {
            // Remove current page from back stack to prevent going back
            popUpTo("page_$currentIndex") { inclusive = true }
        }
    }
}
