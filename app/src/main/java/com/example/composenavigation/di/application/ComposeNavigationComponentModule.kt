package com.example.composenavigation.di.application

import android.app.Application
import android.content.Context
import com.example.composenavigation.ComposeNavigationApplication
import dagger.Binds
import dagger.Module

@Module
interface ComposeNavigationComponentModule {

    @Binds
    fun bindContext(application: ComposeNavigationApplication): Context

    @Binds
    fun bindApplication(application: ComposeNavigationApplication): Application
}