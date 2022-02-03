package com.example.flow.ui.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.flow.ui.viewmodel.navigation.FirstScreenRouter
import com.example.flow.ui.viewmodel.navigation.FirstScreenRouterImpl
import com.example.main.viewmodel.FirstScreenViewModel
import com.example.viewmodel.di.ViewModelFactory
import com.example.viewmodel.di.ViewModelFactoryModule
import com.example.viewmodel.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(
    includes = [
        ViewModelFactoryModule::class
    ]
)
interface FirstScreenModule {

    @Binds
    fun bindViewModelProvider(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(FirstScreenViewModel::class)
    fun bindViewModel(viewModel: FirstScreenViewModel): ViewModel

    @Binds
    fun bindsMainScreenRouter(impl: FirstScreenRouterImpl): FirstScreenRouter
}