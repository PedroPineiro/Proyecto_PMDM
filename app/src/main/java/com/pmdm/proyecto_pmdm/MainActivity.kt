package com.pmdm.proyecto_pmdm


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "home") {
                composable("home") { HomeScreen(navController) }
                composable("createFile") {
                    FileCreatorScreen(navController) { fileName: String, fileExtension: String, fileContent: String ->
                        FileCreator(this@MainActivity).saveTextFile(fileName, fileExtension, fileContent)
                    }
                }
            }
        }
    }
}