package com.example.main.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.di.ComponentFactory
import com.example.di.getComponentFactory
import com.example.flow.ui.navigation.FlowDestinationFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject

class MainScreenComponentFactory @Inject constructor(
    private val flowDestinationFactory: FlowDestinationFactory,
): ComponentFactory {

    fun create(
        navController: NavController,
    ): MainScreenComponent =
        DaggerMainScreenComponent.factory().create(
            navController,
            flowDestinationFactory
        )
}

@Component(
    modules = [
        MainScreenModule::class,
    ]
)
interface MainScreenComponent: ComponentFactory {

    fun getViewModelFactoryProvider(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance navController: NavController,
            @BindsInstance flowDestinationFactory: FlowDestinationFactory,
        ): MainScreenComponent
    }

    companion object {

        fun create(application: Application, navController: NavController): MainScreenComponent =
            getComponentFactory<MainScreenComponentFactory>(application)
                .create(navController)
    }
}