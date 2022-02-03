package com.example.main.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.main.viewmodel.MainScreenViewModel
import com.example.main.viewmodel.navigation.MainScreenRouter
import com.example.main.viewmodel.navigation.MainScreenRouterImpl
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
interface MainScreenModule {

    @Binds
    fun bindViewModelProvider(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainScreenViewModel::class)
    fun bindViewModel(viewModel: MainScreenViewModel): ViewModel

    @Binds
    fun bindsMainScreenRouter(impl: MainScreenRouterImpl): MainScreenRouter
}