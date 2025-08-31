package com.katyshevtseva.auth.di

import androidx.lifecycle.ViewModel
import com.katyshevtseva.auth.presentaion.viewModel.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel
}
