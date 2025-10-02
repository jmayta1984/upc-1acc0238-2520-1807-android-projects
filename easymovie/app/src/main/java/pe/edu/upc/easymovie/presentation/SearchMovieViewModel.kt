package pe.edu.upc.easymovie.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pe.edu.upc.easymovie.domain.Movie
import pe.edu.upc.easymovie.domain.MovieRepository
import javax.inject.Inject

@HiltViewModel
class SearchMovieViewModel @Inject constructor(private val repository: MovieRepository) :
    ViewModel() {
    private val _query = MutableStateFlow("")
    val query: StateFlow<String> = _query


    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> = _movies

    fun onChangeQuery(value: String) {
        _query.value = value
    }

    fun searchMovie() {
        viewModelScope.launch {
            _movies.value = repository.searchMovie(_query.value)
        }
    }
}