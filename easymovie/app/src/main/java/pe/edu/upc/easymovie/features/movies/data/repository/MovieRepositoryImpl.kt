package pe.edu.upc.easymovie.features.movies.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.upc.easymovie.features.movies.data.local.dao.MovieDao
import pe.edu.upc.easymovie.features.movies.data.local.models.MovieEntity
import pe.edu.upc.easymovie.features.movies.data.remote.services.MovieService
import pe.edu.upc.easymovie.features.movies.domain.models.Movie
import pe.edu.upc.easymovie.features.movies.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val service: MovieService,
    private val dao: MovieDao
) : MovieRepository {
    override suspend fun searchMovie(query: String): List<Movie> = withContext(Dispatchers.IO) {

        val response = service.searchMovie(query = query)
        if (response.isSuccessful) {
            response.body()?.let { wrapperDto ->
                return@withContext wrapperDto.movies.map { movieDto ->
                    Movie(
                        id = movieDto.id,
                        title = movieDto.title,
                        posterPath = "https://image.tmdb.org/t/p/w500${movieDto.posterPath}",
                        overview = movieDto.overview,
                        isFavorite = dao.existsFavorite(movieDto.id)
                    )

                }

            }
        }
        return@withContext emptyList()
    }

    override suspend fun addFavorite(movie: Movie) = withContext(Dispatchers.IO) {
        dao.insert(
            MovieEntity(
                id = movie.id,
                title = movie.title,
                posterPath = movie.posterPath,
                overview = movie.overview
            )
        )

    }

    override suspend fun removeFavorite(id: Int) = withContext(Dispatchers.IO) {
        dao.delete(id)
    }
}