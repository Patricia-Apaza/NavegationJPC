package com.edu.upeu.navegationjpc.ui.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController


import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox


data class BottomNavItem(
    val title: String,
    val route: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector,
    val badgeCount: Int = 0)

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavItem("Home", "home", Icons.Default.Home, badgeCount = 5),
        BottomNavItem("Profile", "profile",Icons.Default.Person, badgeCount = 2),
        BottomNavItem("Settings", "settings",Icons.Default.Settings, badgeCount = 3)

    )

    // Estado para gestionar el elemento seleccionado
    var selectedItem by remember { mutableStateOf("home") }
    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = {
                    if (item.badgeCount > 0) {
                        BadgedBox(
                            badge = {
                                Badge(
                                    containerColor = Color.Red,
                                    contentColor = Color.White
                                ) {
                                    Text("${item.badgeCount}")
                                }
                            }
                        ) {
                            Icon(item.icon, contentDescription = item.title)
                        }
                    } else {
                        Icon(item.icon, contentDescription = item.title)
                    }
                },
                label = { Text(item.title) },
                selected = selectedItem == item.route,
                onClick = {
                    selectedItem = item.route
                    navController.navigate(item.route) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Blue,
                    selectedTextColor = Color.Blue,
                    indicatorColor = Color.LightGray,
                    unselectedIconColor = Color.Gray,
                    unselectedTextColor = Color.Gray
                )
            )
        }
    }
}
