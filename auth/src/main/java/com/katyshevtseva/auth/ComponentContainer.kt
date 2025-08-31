package com.katyshevtseva.auth

import com.katyshevtseva.auth.di.AuthComponent
import com.katyshevtseva.auth.di.DaggerAuthComponent

object ComponentContainer {

    val component: AuthComponent by lazy {
        DaggerAuthComponent.create()
    }
}