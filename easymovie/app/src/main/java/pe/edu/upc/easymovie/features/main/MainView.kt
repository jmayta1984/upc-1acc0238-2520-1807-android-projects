package pe.edu.upc.easymovie.features.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Movie
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easymovie.features.favorites.presentation.FavoritesView
import pe.edu.upc.easymovie.features.movies.presentation.SearchMovieView

@Composable
fun MainView(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    val navigationItems = listOf(
        NavigationItem("Movies", Icons.Default.Movie, "search_movies"),
        NavigationItem("Favorites", Icons.Default.Favorite, "favorites")
    )

    val selectedIndex = remember {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            NavigationBar {
                navigationItems.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = selectedIndex.intValue == index,
                        icon = {
                            Icon(item.icon, contentDescription = item.label)
                        },
                        onClick = {
                            selectedIndex.intValue = index
                            navController.navigate(item.route)
                        }
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            navController,
            startDestination = "search_movies",
            modifier = modifier.padding(paddingValues)
        ) {

            composable("search_movies") {
                SearchMovieView()
            }

            composable("favorites") {
                FavoritesView()
            }
        }
    }
}


data class NavigationItem(
    val label: String,
    val icon: ImageVector,
    val route: String
)