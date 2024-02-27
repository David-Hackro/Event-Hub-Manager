package com.david.hackro.di.magic.trick.two.analytics

import android.content.Context
import android.os.Bundle

sealed class AnalyticsManager {

    companion object {
        private val analyticsProviders = HashMap<Class<out AnalyticsProvider>, AnalyticsProvider>()

        fun initialize(providers: List<AnalyticsProvider>) {
            providers.forEach { provider ->
                analyticsProviders[provider.javaClass] = provider
            }
        }

        fun logEvent(eventName: String, params: Bundle = Bundle.EMPTY) {
            val providerClasses = getEventProvidersMap()[eventName]

            providerClasses?.forEach { providerClass ->
                val provider = analyticsProviders[providerClass]
                provider?.logEvent(eventName, params)
            }
        }
    }

    interface AnalyticsProvider {
        fun logEvent(eventName: String, params: Bundle)
    }

    class FirebaseAnalyticsProvider(private val context: Context) : AnalyticsProvider {
        //private val firebaseAnalytics = FirebaseAnalytics.getInstance(context)

        override fun logEvent(eventName: String, params: Bundle) {
            println("Firebase Firebase Analytics - Log Event: $eventName with params: $params")
            //firebaseAnalytics.logEvent(eventName, params)
        }
    }

    class GoogleFirebaseAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implementa lógica para Google Analytics para Firebase
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de Google Analytics para Firebase
            println("Google Firebase Analytics - Log Event: $eventName with params: $params")
        }
    }

    class GoogleAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implementa lógica para Google Analytics
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de Google Analytics
            println("Google Analytics - Log Event: $eventName with params: $params")
        }
    }

    class MixpanelAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implementa lógica para Mixpanel
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de Mixpanel
            println("Mixpanel - Log Event: $eventName with params: $params")
        }
    }

    class AmplitudeAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implementa lógica para Amplitude
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de Amplitude
            println("Amplitude - Log Event: $eventName with params: $params")
        }
    }

    class CountlyAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implementa lógica para Countly
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de Countly
            println("Countly - Log Event: $eventName with params: $params")
        }
    }

    class AppsFlyerAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implementa lógica para AppsFlyer
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de AppsFlyer
            println("AppsFlyer - Log Event: $eventName with params: $params")
        }
    }

    class MatomoAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implementa lógica para Matomo
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de Matomo
            println("Matomo - Log Event: $eventName with params: $params")
        }
    }

    class SentryAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implementa lógica para Sentry
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de Sentry
            println("Sentry - Log Event: $eventName with params: $params")
        }
    }

    class NewRelicAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implementa lógica para New Relic
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de New Relic
            println("New Relic - Log Event: $eventName with params: $params")
        }
    }
}
