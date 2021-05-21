package com.abifarhan.madeapp.core.data.source

import com.abifarhan.madeapp.core.data.source.local.LocalDataSource
import com.abifarhan.madeapp.core.data.source.remote.RemoteDataSource
import com.abifarhan.madeapp.core.data.source.remote.network.ApiResponse
import com.abifarhan.madeapp.core.data.source.remote.response.MovieResponse
import com.abifarhan.madeapp.core.domain.model.Movie
import com.abifarhan.madeapp.core.domain.repository.IMovieRepository
import com.abifarhan.madeapp.core.utils.AppExecutors
import com.abifarhan.madeapp.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
): IMovieRepository {

    override fun getAllMovies(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, List<MovieResponse>>(){
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovies().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovies(movieList)
            }

        }.asFlow()

    override fun getFavoriteMovies(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovies(tourism: Movie, state: Boolean) {
       val movieEntity = DataMapper.mapDomainToEntity(tourism)
        appExecutors.diskIO().execute {
            localDataSource.setFavoriteMovies(movieEntity, state)
        }
    }
}