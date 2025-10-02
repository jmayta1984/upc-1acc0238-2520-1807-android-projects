package pe.edu.upc.easymovie.domain

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import pe.edu.upc.easymovie.data.MovieRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    fun provideMovieRepository(impl: MovieRepositoryImpl): MovieRepository
}