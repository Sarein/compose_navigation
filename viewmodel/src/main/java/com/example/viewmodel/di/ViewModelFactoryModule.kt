package com.example.viewmodel.di

import dagger.Module
import dagger.Provides

@Module
class ViewModelFactoryModule {

    @Provides
    fun provideViewModelFactory(providerMap: ViewModelProviderMap): ViewModelFactory =
            ViewModelFactory(providerMap)
}