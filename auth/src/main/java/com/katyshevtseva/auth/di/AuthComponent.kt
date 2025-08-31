package com.katyshevtseva.auth.di

import com.katyshevtseva.auth.presentaion.AuthActivity
import dagger.Component

@AuthScope
@Component(
    modules = [
        ViewModelModule::class
    ]
)
interface AuthComponent {

    fun inject(fragment: AuthActivity)
}