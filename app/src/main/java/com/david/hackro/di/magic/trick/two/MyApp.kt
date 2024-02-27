package com.david.hackro.di.magic.trick.two

import android.app.Application
import com.david.hackro.di.magic.trick.two.analytics.AnalyticsManager

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        // Initialize providers
        val analyticsProviders = listOf(
            AnalyticsManager.FirebaseAnalyticsProvider(this),
            AnalyticsManager.GoogleFirebaseAnalyticsProvider(this),
            AnalyticsManager.GoogleAnalyticsProvider(this),
            AnalyticsManager.MixpanelAnalyticsProvider(this),
            AnalyticsManager.AmplitudeAnalyticsProvider(this),
            AnalyticsManager.CountlyAnalyticsProvider(this),
            AnalyticsManager.AppsFlyerAnalyticsProvider(this),
            AnalyticsManager.MatomoAnalyticsProvider(this),
            AnalyticsManager.SentryAnalyticsProvider(this),
            AnalyticsManager.NewRelicAnalyticsProvider(this)
        )

        AnalyticsManager.initialize(analyticsProviders)
    }
}
