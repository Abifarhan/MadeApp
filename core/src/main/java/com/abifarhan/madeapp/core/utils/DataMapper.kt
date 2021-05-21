package com.abifarhan.madeapp.core.utils

import com.abifarhan.madeapp.core.data.source.local.entity.MovieEntity
import com.abifarhan.madeapp.core.data.source.remote.response.MovieResponse
import com.abifarhan.madeapp.core.domain.model.Movie

object DataMapper {

    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {

        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id,
                movieName = it.name,
                moviePoster = it.poster,
                movieOverview = it.overview,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>):
            List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                name = it.movieName,
                poster = it.moviePoster,
                overview = it.movieOverview,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        movieName = input.name,
        moviePoster = input.poster,
        movieOverview = input.overview,
        isFavorite = input.isFavorite
    )
}