package com.david.hackro.di.magic.trick.two.analytics

import android.content.Context
import android.os.Bundle

sealed class AnalyticsManager {

    companion object {
        // Map to store analytics providers
        private val analyticsProviders = HashMap<Class<out AnalyticsProvider>, AnalyticsProvider>()

        /**
         * Initialize the AnalyticsManager with a list of AnalyticsProviders.
         * @param providers List of AnalyticsProviders to be initialized.
         */
        fun initialize(providers: List<AnalyticsProvider>) {
            providers.forEach { provider ->
                analyticsProviders[provider.javaClass] = provider
            }
        }

        /**
         * Log an event to all registered AnalyticsProviders.
         * @param eventName The name of the event to log.
         * @param params Additional parameters for the event.
         */
        fun logEvent(eventName: String, params: Bundle = Bundle.EMPTY) {
            val providerClasses = getEventProvidersMap()[eventName]

            providerClasses?.forEach { providerClass ->
                val provider = analyticsProviders[providerClass]
                provider?.logEvent(eventName, params)
            }
        }
    }

    /**
     * Interface for Analytics Providers.
     */
    interface AnalyticsProvider {
        /**
         * Log an event.
         * @param eventName The name of the event to log.
         * @param params Additional parameters for the event.
         */
        fun logEvent(eventName: String, params: Bundle)
    }

    // Concrete Analytics Providers

    class FirebaseAnalyticsProvider(private val context: Context) : AnalyticsProvider {
        // TODO: Uncomment the following line to use Firebase Analytics
        // private val firebaseAnalytics = FirebaseAnalytics.getInstance(context)

        override fun logEvent(eventName: String, params: Bundle) {
            println("Firebase Firebase Analytics - Log Event: $eventName with params: $params")
            // TODO: Uncomment the following line to log the event with Firebase Analytics
            // firebaseAnalytics.logEvent(eventName, params)
        }
    }

    class GoogleFirebaseAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implement logic for Google Analytics for Firebase
        override fun logEvent(eventName: String, params: Bundle) {
            // Specific logic for Google Analytics for Firebase
            println("Google Firebase Analytics - Log Event: $eventName with params: $params")
        }
    }

    class GoogleAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implement logic for Google Analytics
        override fun logEvent(eventName: String, params: Bundle) {
            // Specific logic for Google Analytics
            println("Google Analytics - Log Event: $eventName with params: $params")
        }
    }

    class MixpanelAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implement logic for  Mixpanel
        override fun logEvent(eventName: String, params: Bundle) {
            // Specific logic for  Mixpanel
            println("Mixpanel - Log Event: $eventName with params: $params")
        }
    }

    class AmplitudeAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implement logic for  Amplitude
        override fun logEvent(eventName: String, params: Bundle) {
            // Specific logic for  Amplitude
            println("Amplitude - Log Event: $eventName with params: $params")
        }
    }

    class CountlyAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implement logic for  Countly
        override fun logEvent(eventName: String, params: Bundle) {
            // Specific logic for  Countly
            println("Countly - Log Event: $eventName with params: $params")
        }
    }

    class AppsFlyerAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implement logic for  AppsFlyer
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de AppsFlyer
            println("AppsFlyer - Log Event: $eventName with params: $params")
        }
    }

    class MatomoAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implement logic for  Matomo
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de Matomo
            println("Matomo - Log Event: $eventName with params: $params")
        }
    }

    class SentryAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implement logic for  Sentry
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de Sentry
            println("Sentry - Log Event: $eventName with params: $params")
        }
    }

    class NewRelicAnalyticsProvider(context: Context) : AnalyticsProvider {
        // Implement logic for  New Relic
        override fun logEvent(eventName: String, params: Bundle) {
            // Lógica específica de New Relic
            println("New Relic - Log Event: $eventName with params: $params")
        }
    }
}
