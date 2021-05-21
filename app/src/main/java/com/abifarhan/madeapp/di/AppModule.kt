package com.abifarhan.madeapp.di

import com.abifarhan.madeapp.core.domain.usecase.MovieUseCase
import com.abifarhan.madeapp.detail.DetailMovieViewModel
import com.abifarhan.madeapp.home.HomeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase>{ com.abifarhan.madeapp.core.domain.usecase.MovieInteractor(get())}
}

val viewModelModule = module{
    viewModel{HomeViewModel(get())}
    viewModel { DetailMovieViewModel(get()) }
}