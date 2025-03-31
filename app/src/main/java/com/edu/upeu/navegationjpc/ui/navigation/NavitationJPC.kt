package com.edu.upeu.navegationjpc.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.edu.upeu.navegationjpc.ui.presentation.screens.HomeScreen
import com.edu.upeu.navegationjpc.ui.presentation.screens.ProfileScreen
import com.edu.upeu.navegationjpc.ui.presentation.screens.SettingsScreen

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen() }
        composable("profile") { ProfileScreen() }
        composable("settings") { SettingsScreen() }
    }
}