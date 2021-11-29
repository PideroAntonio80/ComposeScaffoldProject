package com.example.composescaffoldproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import com.example.composescaffoldproject.ui.navigation.Navigation

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
            /*ComposeScaffoldApp {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "main") {
                    composable("main") {
                        MainScreen(navController)
                    }
                    composable(
                        route = "detail/{mediaId}",
                        arguments = listOf(navArgument("mediaId") { type = NavType.IntType }
                        )
                    ) { backStackEntry ->
                        val id = backStackEntry.arguments?.getInt("mediaId")
                        requireNotNull(id)  // <-- Esto se podría sustituir por poner en la siguiente línea: "DetailScreen(id!!)"
                        DetailScreen(id)
                    }
                }
            }*/
        }
    }
}

// Si quisiera que pudiera ser nullable el argumento (o sea, poder pasarlo o no) lo pondría así:
// "detail?mediaId={mediaId}"   <-- Esto en la línea 23 en lugar de "{mediaId}

