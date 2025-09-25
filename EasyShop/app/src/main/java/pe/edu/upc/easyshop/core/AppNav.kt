package pe.edu.upc.easyshop.core

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.features.auth.presentation.di.PresentationModule.getLoginViewModel
import pe.edu.upc.easyshop.features.auth.presentation.login.Login
import pe.edu.upc.easyshop.features.auth.presentation.login.LoginViewModel

@Composable
fun AppNav() {

    val navController = rememberNavController()
    val viewModel: LoginViewModel = getLoginViewModel()
    NavHost(navController, startDestination = Route.Login.route) {

        composable(Route.Login.route)
        {
            Login(viewModel) {
                navController.navigate(Route.Main.route)
            }

        }

        composable(Route.Main.route) {
            Main {
                navController.navigate(Route.ProductDetail.route)
            }
        }

        composable(Route.ProductDetail.route) {

        }


    }
}

@Preview
@Composable
fun AppNavPreview() {
    EasyShopTheme {
        AppNav()
    }
}


sealed class Route(val route: String) {
    object Main : Route("main")
    object Login : Route("login")
    object ProductDetail : Route("product_detail")

}