package com.example.composescaffoldproject.ui.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class NavItem(
    internal val baseRoute: String,
    private val navArgs: List<NavArg> = emptyList()
) {
    object Main: NavItem("main")
    object Detail: NavItem("detail", listOf(NavArg.MediaId)) {
        fun createRoute(mediaId: Int) = "$baseRoute/$mediaId"
    }

    val route = run {
        val argKeys = navArgs.map { "{${it.key}}" }
        listOf(baseRoute)
            .plus(argKeys)
            .joinToString("/")
    }

    val args = navArgs.map {
        navArgument(it.key) { type = it.navType }
    }
}

enum class NavArg(val key: String, val navType: NavType<*>) {
    MediaId("mediaId", NavType.IntType)
}
