package com.example.composenavigation.di.flow

import com.example.di.ComponentFactory
import com.example.di.ComponentKey
import com.example.flow.ui.di.FirstScreenComponentFactory
import com.example.flow.ui.di.SecondScreenComponentFactory
import com.example.flow.ui.navigation.FirstScreenDestinationFactory
import com.example.flow.ui.navigation.FlowDestinationFactory
import com.example.flow.ui.navigation.FlowNavigationFactory
import com.example.flow.ui.navigation.SecondScreenDestinationFactory
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
interface FlowModule {

    @Binds
    @IntoMap
    @ComponentKey(FirstScreenComponentFactory::class)
    fun bindFirstScreenComponentFactory(impl: FirstScreenComponentFactory): ComponentFactory

    @Binds
    @IntoMap
    @ComponentKey(SecondScreenComponentFactory::class)
    fun providdSecondScreenComponentFactory(imp: SecondScreenComponentFactory): ComponentFactory

    companion object {
        @Provides
        fun bindFirstScreenDestinationFactory(): FirstScreenDestinationFactory =
            FlowNavigationFactory

        @Provides
        fun bindSecondScreenDestinationFactory(): SecondScreenDestinationFactory =
            FlowNavigationFactory

        @Provides
        fun bindFlowDestinationFactory(): FlowDestinationFactory =
            FlowNavigationFactory
    }
}