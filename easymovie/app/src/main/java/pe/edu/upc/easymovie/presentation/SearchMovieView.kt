package pe.edu.upc.easymovie.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import coil3.compose.AsyncImage
import pe.edu.upc.easymovie.domain.Movie

@Preview(showBackground = true)
@Composable
fun SearchMovieView(
    viewModel: SearchMovieViewModel = hiltViewModel()
) {
    val query = viewModel.query.collectAsState()
    val movies = viewModel.movies.collectAsState()

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 32.dp)) {
        OutlinedTextField(
            value = query.value,
            onValueChange = {
                viewModel.onChangeQuery(it)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                IconButton(onClick = {
                    viewModel.searchMovie()
                }) {
                    Icon(Icons.Default.Search, contentDescription = null)
                }
            }
        )
        LazyColumn {
            items(movies.value) { movie ->
                MovieCard(movie)
            }
        }
    }
}


@Composable
fun MovieCard(movie: Movie) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Row {
            AsyncImage(
                model = movie.image,
                contentDescription = null,
                modifier = Modifier.size(96.dp),
                contentScale = ContentScale.Fit
            )
            Text(
                movie.title,
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}