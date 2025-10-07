package pe.edu.upc.easymovie.features.favorites.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import pe.edu.upc.easymovie.features.movies.domain.models.Movie


@Composable
fun FavoriteCard(
    movie: Movie,
    onToggleFavorite: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row {
            AsyncImage(
                model = movie.posterPath,
                contentDescription = null,
                modifier = Modifier
                    .height(112.dp)
                    .width(56.dp)
                    .clip(RoundedCornerShape(8.dp)),
                contentScale = ContentScale.FillHeight
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(
                    movie.title,
                    style = MaterialTheme.typography.titleSmall,
                    maxLines = 1
                )
                Text(
                    movie.overview,
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 2
                )
            }

            IconButton(onClick = onToggleFavorite) {
                Icon(
                    Icons.Default.Delete, contentDescription = null
                )
            }

        }
    }
}