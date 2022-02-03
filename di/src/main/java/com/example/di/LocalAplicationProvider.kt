package com.example.di

import android.app.Application
import androidx.compose.runtime.staticCompositionLocalOf
import java.lang.IllegalStateException

val LocalApplicationProvider = staticCompositionLocalOf<Application> { throw IllegalStateException("The Application is Empty") }