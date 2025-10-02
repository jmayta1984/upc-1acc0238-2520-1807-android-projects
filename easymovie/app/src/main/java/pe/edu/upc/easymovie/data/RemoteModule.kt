package pe.edu.upc.easymovie.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    @Provides
    @Singleton
    @Named("base_url")
    fun provideApiBaseUrl() = "https://api.themoviedb.org/3/"


    @Provides
    @Singleton
    fun provideRetrofit(@Named("base_url") url: String): Retrofit {
        return retrofit2.Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provieProductService(retrofit: Retrofit): MovieService {
        return retrofit.create(MovieService::class.java)
    }
}