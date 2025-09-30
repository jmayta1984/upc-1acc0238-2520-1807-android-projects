package pe.edu.upc.easyshop.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.features.auth.presentation.login.Login
import pe.edu.upc.easyshop.features.auth.presentation.login.LoginViewModel
import pe.edu.upc.easyshop.features.home.presentation.productdetail.ProductDetail
import pe.edu.upc.easyshop.features.home.presentation.productdetail.ProductDetailViewModel

@Composable
fun AppNav() {

    val navController = rememberNavController()
    val viewModel: LoginViewModel = hiltViewModel()
    NavHost(navController, startDestination = Route.Login.route) {

        composable(Route.Login.route)
        {
            Login(viewModel) {
                navController.navigate(Route.Main.route)
            }

        }

        composable(Route.Main.route) {
            Main { productId ->
                navController.navigate("${Route.ProductDetail.route}/$productId")
            }
        }

        composable(
            route = Route.ProductDetail.routeWithArgument,
            arguments = listOf(
                navArgument(Route.ProductDetail.argument) {
                    type = NavType.IntType
                })
        ) { backStackEntry ->
            backStackEntry.arguments?.let { arguments ->
                val productId = arguments.getInt(Route.ProductDetail.argument)
                val productDetailViewModel: ProductDetailViewModel = hiltViewModel()
                productDetailViewModel.getProductById(productId)

                val product by productDetailViewModel.product.collectAsState()
                product?.let {
                    ProductDetail(it)
                }
            }

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
    object ProductDetail : Route("product_detail") {
        const val routeWithArgument = "product_detail/{id}"
        const val argument = "id"
    }

}