package com.example.di

import android.app.Application
import dagger.MapKey
import javax.inject.Provider
import kotlin.reflect.KClass

interface ComponentFactory

interface ComponentFactoryProvider {

    fun getComponentFactories(): Map<Class<out ComponentFactory>, @JvmSuppressWildcards Provider<ComponentFactory>>
}

@MapKey
@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
annotation class ComponentKey(val value: KClass<out ComponentFactory>)

inline fun <reified WC : ComponentFactory> getComponentFactory(application: Application): WC =
    (application as? ComponentFactoryProvider)?.let { componentProvider ->
        val componentsMap = componentProvider.getComponentFactories()
        componentsMap[WC::class.java]?.get() as? WC
    } ?: error("Cannot create dependency ${WC::class.java}")