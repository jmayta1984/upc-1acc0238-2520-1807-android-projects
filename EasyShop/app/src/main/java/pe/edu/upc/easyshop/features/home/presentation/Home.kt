package pe.edu.upc.easyshop.features.home.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.FilterList
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pe.edu.upc.easyshop.R
import pe.edu.upc.easyshop.core.ui.components.ProductCard
import pe.edu.upc.easyshop.core.ui.components.RoundedIcon
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.shared.model.products

@Composable
fun Home(onClick: () -> Unit) {

    val categories = listOf(
        Category.All,
        Category.Men,
        Category.Women,
        Category.Boys,
        Category.Girls
    )

    val selectedCategory = remember {
        mutableStateOf<Category>(Category.All)

    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .height(64.dp)
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(MaterialTheme.colorScheme.primary)
            ) {
                Icon(
                    Icons.Default.Person,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    "Hello Alex",
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    "Good morning!",
                    style = MaterialTheme.typography.titleMedium,

                    )
            }
            RoundedIcon(Icons.Outlined.Notifications)
            Spacer(modifier = Modifier.width(8.dp))
            RoundedIcon(Icons.Outlined.ShoppingCart)

        }

        Row(
            modifier = Modifier
                .height(64.dp)
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = "", onValueChange = {},
                modifier = Modifier.weight(1f),
                placeholder = { Text(stringResource(R.string.placeholder_search)) },
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = null
                    )
                }
            )
            Spacer(modifier = Modifier.width(8.dp))
            RoundedIcon(Icons.Outlined.FilterList)
        }

        Row(
            modifier = Modifier
                .height(64.dp)
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                stringResource(R.string.label_categories),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = {}) { Text(stringResource(R.string.button_see_all)) }
        }

        LazyRow {
            items(categories) { category ->
                FilterChip(
                    selected = category == selectedCategory.value,
                    onClick = {
                        selectedCategory.value = category
                    },
                    label = {
                        Text(category.label)
                    },
                    modifier = Modifier.padding(8.dp)
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(192.dp)
                .padding(horizontal = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .background(
                        brush = Brush.linearGradient(
                            listOf(
                                MaterialTheme.colorScheme.primary,
                                MaterialTheme.colorScheme.inversePrimary
                            )
                        )
                    )
            )

            {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .padding(start = 16.dp, end = 24.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Get your special sale up to 40%",
                        style = MaterialTheme.typography.headlineSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                    ElevatedButton(onClick = {}) { Text("Shop now") }
                }
                Image(
                    painterResource(R.drawable.banner),
                    contentDescription = null,
                    modifier = Modifier.weight(1f),
                    contentScale = ContentScale.FillWidth
                )
            }
        }

        Row(
            modifier = Modifier
                .height(64.dp)
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                stringResource(R.string.label_products),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.weight(1f)
            )
            TextButton(onClick = {}) { Text("See all") }
        }

        LazyVerticalGrid(columns = GridCells.Fixed(2)) {
            items(products) { product ->
                ProductCard(product, onClick)
            }
        }
    }
}


sealed class Category(val label: String) {
    object All : Category("All")
    object Men : Category("Men")
    object Women : Category("Women")
    object Boys : Category("Boys")
    object Girls : Category("Girls")
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    EasyShopTheme {
        Home{}
    }
}
