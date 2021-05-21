package com.abifarhan.madeapp.core.domain.usecase

import com.abifarhan.madeapp.core.data.source.Resource
import com.abifarhan.madeapp.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieUseCase {
    fun getAllMovies(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovies(): Flow<List<Movie>>
    fun setFavoriteMovies(tourism: Movie, state: Boolean)
}