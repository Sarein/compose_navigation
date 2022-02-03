package com.example.composenavigation

import android.app.Application
import com.example.composenavigation.di.application.ComposeNavigationComponent
import com.example.composenavigation.di.application.DaggerComposeNavigationComponent
import com.example.di.ComponentFactory
import com.example.di.ComponentFactoryProvider
import javax.inject.Provider

class ComposeNavigationApplication: Application(), ComponentFactoryProvider {

    private lateinit var applicationComponent: ComposeNavigationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerComposeNavigationComponent.factory().create(this)
    }


    override fun getComponentFactories(): Map<Class<out ComponentFactory>, Provider<ComponentFactory>> =
        applicationComponent.getComponentFactories()
}