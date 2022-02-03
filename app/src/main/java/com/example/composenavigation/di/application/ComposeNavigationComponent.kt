package com.example.composenavigation.di.application

import com.example.composenavigation.ComposeNavigationApplication
import com.example.composenavigation.di.flow.FlowModule
import com.example.composenavigation.di.mainscreen.MainScreenModule
import com.example.di.ComponentFactoryProvider
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        ComposeNavigationComponentModule::class,
        FlowModule::class,
        MainScreenModule::class,
    ]
)
@Singleton
internal interface ComposeNavigationComponent : ComponentFactoryProvider {

    fun inject(application: ComposeNavigationApplication)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: ComposeNavigationApplication,
        ): ComposeNavigationComponent
    }
}