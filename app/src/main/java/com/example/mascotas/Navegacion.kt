package com.example.mascotas

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Preview(showBackground = true)
@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "Registro") {
        composable(route = "Registro") {
            Registro(navController)
        }
        composable(
            "Carnet/{nombre}/{raza}/{tamaño}/{edad}/{foto}",
            arguments = listOf(
                navArgument("nombre") { type = NavType.StringType },
                navArgument("raza") { type = NavType.StringType },
                navArgument("tamaño") { type = NavType.StringType },
                navArgument("edad") { type = NavType.StringType },
                navArgument("foto") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val nombre = backStackEntry.arguments?.getString("nombre") ?: ""
            val raza = backStackEntry.arguments?.getString("raza") ?: ""
            val tamaño = backStackEntry.arguments?.getString("tamaño") ?: ""
            val edad = backStackEntry.arguments?.getString("edad") ?: ""
            val foto = backStackEntry.arguments?.getString("foto") ?: ""

            Carnet(navController, nombre, raza, tamaño, edad, foto)
        }
    }
}