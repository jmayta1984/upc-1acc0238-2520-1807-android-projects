package pe.edu.upc.easymovie.features.movies.domain.repository

import pe.edu.upc.easymovie.features.movies.domain.models.Movie

interface MovieRepository {

    suspend fun searchMovie(query: String): List<Movie>

    suspend fun addFavorite(movie: Movie)

    suspend fun removeFavorite(id: Int)

    suspend fun getAllFavorites(): List<Movie>
}