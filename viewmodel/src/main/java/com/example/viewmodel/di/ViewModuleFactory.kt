package com.example.viewmodel.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider

internal typealias ViewModelProviderMap = Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>

class ViewModelFactory(
    private val providerMap: ViewModelProviderMap,
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModelProvider = providerMap[modelClass]
            ?: error("model class $modelClass not found")
        return viewModelProvider.get() as T
    }
}