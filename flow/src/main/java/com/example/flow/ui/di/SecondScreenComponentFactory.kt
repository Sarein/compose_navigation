package com.example.flow.ui.di

import android.app.Application
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import com.example.di.ComponentFactory
import com.example.di.getComponentFactory
import com.example.flow.ui.navigation.FirstScreenDestinationFactory
import dagger.BindsInstance
import dagger.Component
import javax.inject.Inject

class SecondScreenComponentFactory @Inject constructor(
    private val firstScreenDestinationFactory: FirstScreenDestinationFactory,
) : ComponentFactory {

    internal fun create(
        navController: NavController,
        counter: Int,
    ): SecondScreenComponent =
        DaggerSecondScreenComponent.factory().create(
            navController,
            firstScreenDestinationFactory,
            counter,
        )
}

@Component(
    modules = [
        SecondScreenModule::class,
    ]
)
internal interface SecondScreenComponent {

    fun getViewModelFactoryProvider(): ViewModelProvider.Factory

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance navController: NavController,
            @BindsInstance firstScreenDestinationFactory: FirstScreenDestinationFactory,
            @BindsInstance counter: Int,
        ): SecondScreenComponent
    }

    companion object {

        fun create(application: Application, navController: NavController, counter: Int): SecondScreenComponent =
            getComponentFactory<SecondScreenComponentFactory>(application)
                .create(navController, counter)
    }
}