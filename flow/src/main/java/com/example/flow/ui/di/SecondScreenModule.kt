package com.example.flow.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flow.ui.viewmodel.navigation.SecondScreenRouter
import com.example.flow.ui.viewmodel.navigation.SecondScreenRouterImpl
import com.example.main.viewmodel.SecondScreenViewModel
import com.example.viewmodel.di.ViewModelFactory
import com.example.viewmodel.di.ViewModelFactoryModule
import com.example.viewmodel.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        ViewModelFactoryModule::class,
    ]
)
interface SecondScreenModule {

    @Binds
    fun bindViewModelProvider(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SecondScreenViewModel::class)
    fun bindViewModel(viewModel: SecondScreenViewModel): ViewModel

    @Binds
    fun bindsMainScreenRouter(impl: SecondScreenRouterImpl): SecondScreenRouter
}