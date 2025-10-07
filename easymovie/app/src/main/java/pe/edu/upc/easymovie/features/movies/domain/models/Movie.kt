package pe.edu.upc.easymovie.features.movies.domain.models

data class Movie(
    val id: Int,
    val posterPath: String,
    val title: String,
    val overview: String,
    val isFavorite: Boolean = false
)