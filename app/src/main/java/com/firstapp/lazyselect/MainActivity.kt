package com.firstapp.lazyselect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.firstapp.lazyselect.screens.DatailScreen
import com.firstapp.lazyselect.screens.MainScreen
import com.firstapp.lazyselect.ui.theme.LazySelectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazySelectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val names = arrayOf(
                        "Peperoni",
                        "Vegan",
                        "Four Chesses",
                        "Maraaritte",
                        "American",
                        "Mexican"
                    )
                    val ingredients = arrayOf(
                        "Tomatos sos, chesse, oregano, peperoni",
                        "Item 1 sos, chesse, oregano, peperoni, item 1a, item 1b",
                        "Item 2 sos, chesse, oregano, peperoni, item 2a, item 2b",
                        "Item 3 sos, chesse, oregano, peperoni, item 3a, item 3b",
                        "Item 4 sos, chesse, oregano, peperoni, item 4a, item 4b",
                        "Item 5 sos, chesse, oregano, peperoni, item 5a, item 5b",
                    )
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "MainScreen") {
                        composable(route = "MainScreen") {
                            MainScreen(names, ingredients, navController)
                        }
                        composable(route = "DetailScreen/{index}",
                            arguments = listOf(
                                navArgument(name = "index") {
                                    type = NavType.IntType
                                }
                            )
                        )
                        {
                            index -> DatailScreen(
                            names = names,
                            ingredients = ingredients,
                            itemIndex = index.arguments?.getInt("index"))
                        }
                    }
                }
            }
        }
    }
}

