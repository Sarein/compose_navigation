package com.example.composenavigation.di.mainscreen

import com.example.di.ComponentFactory
import com.example.di.ComponentKey
import com.example.main.di.MainScreenComponentFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface MainScreenModule {

    @Binds
    @IntoMap
    @ComponentKey(MainScreenComponentFactory::class)
    fun bindMainScreenComponentFactory(impl: MainScreenComponentFactory): ComponentFactory
}