package pe.edu.upc.easyshop.core

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.features.home.presentation.di.PresentationModule.getHomeViewModel
import pe.edu.upc.easyshop.features.home.presentation.views.Home


data class NavigationItem(
    val icon: ImageVector,
    val route: String
)

@Composable
fun Main(onClick: () -> Unit) {

    val selectedTab = remember {
        mutableStateOf(0)
    }

    val navigationItems = listOf(
        NavigationItem(icon = Icons.Default.Home, route = "Home"),
        NavigationItem(icon = Icons.Default.Favorite, route = "Favorites"),
        NavigationItem(icon = Icons.Default.ShoppingCart, route = "Cart"),
        NavigationItem(icon = Icons.Default.Person, route = "Profile"),

        )

    Scaffold(
        bottomBar = {
            BottomAppBar {
               navigationItems.forEachIndexed { index, item ->
                   NavigationBarItem(
                       selected = index == selectedTab.value,
                       icon = {
                           Icon(item.icon, contentDescription = null)
                       },
                       label = {
                           Text(text = item.route)
                       },
                       onClick = {
                           selectedTab.value = index
                       }
                   )
               }
            }
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Home(getHomeViewModel(),onClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainPreview() {
    EasyShopTheme {
        Main{}
    }
}