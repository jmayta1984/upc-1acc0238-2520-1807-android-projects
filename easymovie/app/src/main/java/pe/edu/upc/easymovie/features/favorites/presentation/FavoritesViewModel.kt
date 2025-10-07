package pe.edu.upc.easymovie.features.favorites.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.easymovie.features.movies.domain.models.Movie
import pe.edu.upc.easymovie.features.movies.domain.repository.MovieRepository
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies


    private fun getAllFavorites() {
        viewModelScope.launch {
            _movies.value = repository.getAllFavorites()
        }
    }

    fun removeFavorite(movie: Movie) {
        viewModelScope.launch {
            repository.removeFavorite(movie.id)
        }
        _movies.value = _movies.value.filterNot { it.id == movie.id }
    }

    init {
        getAllFavorites()
    }
}