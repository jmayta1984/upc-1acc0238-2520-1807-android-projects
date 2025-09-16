package pe.edu.upc.easyshop.features.home.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.shared.model.Product
import pe.edu.upc.easyshop.shared.model.products

@Composable
fun ProductDetail(product: Product) {
    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(256.dp)
                    .background(MaterialTheme.colorScheme.inversePrimary),
                contentScale = ContentScale.FillWidth

            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProductDetailPreview() {
    EasyShopTheme {
        ProductDetail(products[0])
    }
}