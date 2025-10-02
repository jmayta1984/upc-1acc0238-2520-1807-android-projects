package pe.edu.upc.easymovie.domain

interface MovieRepository {

    suspend fun searchMovie(query: String): List<Movie>
}