package com.example.flow.ui.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.di.ComponentFactory
import com.example.di.getComponentFactory
import com.example.flow.ui.navigation.SecondScreenDestinationFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject

class FirstScreenComponentFactory @Inject constructor(
    private val secondScreenDestinationFactory: SecondScreenDestinationFactory,
) : ComponentFactory {

    internal fun create(
        navController: NavController,
    ): FirstScreenComponent =
        DaggerFirstScreenComponent.factory().create(navController, secondScreenDestinationFactory)
}

@Component(
    modules = [
        FirstScreenModule::class,
    ]
)
internal interface FirstScreenComponent {

    fun getViewModelFactoryProvider(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance navController: NavController,
            @BindsInstance secondScreenDestinationFactory: SecondScreenDestinationFactory,
        ): FirstScreenComponent
    }

    companion object {

        fun create(application: Application, navController: NavController): FirstScreenComponent =
            getComponentFactory<FirstScreenComponentFactory>(application)
                .create(navController)
    }
}