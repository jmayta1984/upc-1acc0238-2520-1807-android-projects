package pe.edu.upc.easyshop.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.shared.model.Product
import pe.edu.upc.easyshop.shared.model.products

@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .height(192.dp)
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .padding(8.dp),
            contentAlignment = Alignment.BottomStart
        ) {
            Column {
                AsyncImage(
                    model = product.image,
                    contentDescription = null,
                    modifier = Modifier.height(128.dp),
                    contentScale = ContentScale.Crop
                )
                Text(product.name)
                Text("$ ${product.price}", fontWeight = FontWeight.SemiBold)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    EasyShopTheme {
        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(products) { product ->
                ProductCard(product) {}
            }
        }
    }
}