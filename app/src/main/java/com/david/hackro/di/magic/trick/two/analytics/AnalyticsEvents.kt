package com.david.hackro.di.magic.trick.two.analytics

import com.david.hackro.di.magic.trick.two.analytics.AnalyticsManager.AnalyticsProvider
import com.david.hackro.di.magic.trick.two.analytics.AnalyticsManager.FirebaseAnalyticsProvider
import com.david.hackro.di.magic.trick.two.analytics.AnalyticsManager.GoogleFirebaseAnalyticsProvider
import com.david.hackro.di.magic.trick.two.analytics.AnalyticsManager.MixpanelAnalyticsProvider

// Event identifiers
const val HOME_SCREEN_CLICK_PRIMARY_BUTTON = "home_screen_click_primary_button"
const val HOME_SCREEN_CLICK_SECONDARY_BUTTON = "home_screen_click_secondary_button"

// Map to associate event identifiers with the corresponding analytics providers
private val eventProvidersMap =
    HashMap<String, List<Class<out AnalyticsProvider>>>().apply {
        this[HOME_SCREEN_CLICK_PRIMARY_BUTTON] = listOf(FirebaseAnalyticsProvider::class.java, GoogleFirebaseAnalyticsProvider::class.java)
        this[HOME_SCREEN_CLICK_SECONDARY_BUTTON] = listOf(FirebaseAnalyticsProvider::class.java, GoogleFirebaseAnalyticsProvider::class.java, MixpanelAnalyticsProvider::class.java)
    }

fun getEventProvidersMap(): Map<String, List<Class<out AnalyticsProvider>>> {
    return eventProvidersMap.toMap()
}
