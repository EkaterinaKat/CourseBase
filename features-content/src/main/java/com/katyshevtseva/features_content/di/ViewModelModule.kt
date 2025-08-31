package com.katyshevtseva.features_content.di

import androidx.lifecycle.ViewModel
import com.katyshevtseva.features_content.presentation.viewmodel.FavouritesViewModel
import com.katyshevtseva.features_content.presentation.viewmodel.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(FavouritesViewModel::class)
    fun bindFavouritesViewModel(viewModel: FavouritesViewModel): ViewModel
}
