package com.katyshevtseva.features_content

import android.app.Application
import com.katyshevtseva.features_content.di.DaggerFeatureContentComponent
import com.katyshevtseva.features_content.di.FeatureContentComponent

object ComponentContainer {

    private var _component: FeatureContentComponent? = null
    val component: FeatureContentComponent
        get() = _component ?: throw RuntimeException("FeatureContentComponent not initialized")

    fun initComponent(application: Application) {
        _component = DaggerFeatureContentComponent.factory().create(application)
    }
}