package com.abifarhan.madeapp.core.data.source.local

import com.abifarhan.madeapp.core.data.source.local.entity.MovieEntity
import com.abifarhan.madeapp.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    fun getFavoriteMovies(): Flow<List<MovieEntity>> =
        movieDao.getFavoriteMovies()

    suspend fun insertMovies(moviesList: List<MovieEntity>) =
        movieDao.insertMovies(moviesList)


    fun setFavoriteMovies(
        movies: MovieEntity,
        newState: Boolean
    ) {
        movies.isFavorite = newState
        movieDao.updateFavoriteMovie(movies)
    }
}