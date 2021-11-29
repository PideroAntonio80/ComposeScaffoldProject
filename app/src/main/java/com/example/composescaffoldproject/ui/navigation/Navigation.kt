package com.example.composescaffoldproject.ui.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composescaffoldproject.ui.screens.detail.DetailScreen
import com.example.composescaffoldproject.ui.screens.main.MainScreen

@ExperimentalFoundationApi
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavItem.Main.route) {
        composable(NavItem.Main.route) {
            MainScreen { mediaItem ->
                navController.navigate(NavItem.Detail.createRoute(mediaItem.id)) }
        }
        composable(
            route = NavItem.Detail.route,
            arguments = NavItem.Detail.args
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt(NavArg.MediaId.key)
            requireNotNull(id)  // <-- Esto se podría sustituir por poner en la siguiente línea: "DetailScreen(mediaId = id!!,...)"
            DetailScreen(mediaId = id, onUpClick = { navController.popBackStack() })
        }
    }
}

