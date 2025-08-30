package com.katyshevtseva.features_content.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component
interface FeatureContentComponent {

    fun getApplication(): Application

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): FeatureContentComponent
    }
}