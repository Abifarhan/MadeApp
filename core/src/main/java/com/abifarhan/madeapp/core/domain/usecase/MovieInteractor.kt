package com.abifarhan.madeapp.core.domain.usecase

import com.abifarhan.madeapp.core.data.source.Resource
import com.abifarhan.madeapp.core.domain.model.Movie
import com.abifarhan.madeapp.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val movieRepository: IMovieRepository) :
    MovieUseCase {
    override fun getAllMovies(): Flow<Resource<List<Movie>>> =
        movieRepository.getAllMovies()

    override fun getFavoriteMovies(): Flow<List<Movie>> =
        movieRepository.getFavoriteMovies()

    override fun setFavoriteMovies(movie: Movie, state: Boolean) =
        movieRepository.setFavoriteMovies(movie, state)
}