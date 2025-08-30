package com.katyshevtseva.features_content.di

import android.app.Application
import com.katyshevtseva.features_content.presentation.HomeFragment
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [
        ViewModelModule::class,
        DataModule::class
    ]
)
interface FeatureContentComponent {

    fun inject(fragment: HomeFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): FeatureContentComponent
    }
}