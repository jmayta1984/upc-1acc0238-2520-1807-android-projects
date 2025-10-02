package pe.edu.upc.easymovie.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query



interface MovieService {

    @GET("search/movie")
    suspend fun searchMovie(
        @Query("api_key") apiKey: String = "3cae426b920b29ed2fb1c0749f258325",
        @Query("query") query: String
    ): Response<MoviesWrapperDto>
}