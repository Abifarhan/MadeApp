package com.abifarhan.madeapp.favorite.di

import com.abifarhan.madeapp.favorite.FavoritViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module{
    viewModel { FavoritViewModel(get()) }
}