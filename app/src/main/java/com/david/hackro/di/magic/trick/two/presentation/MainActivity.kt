package com.david.hackro.di.magic.trick.two.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.david.hackro.di.magic.trick.two.analytics.AnalyticsManager
import com.david.hackro.di.magic.trick.two.analytics.HOME_SCREEN_CLICK_PRIMARY_BUTTON
import com.david.hackro.di.magic.trick.two.analytics.HOME_SCREEN_CLICK_SECONDARY_BUTTON
import com.david.hackro.di.magic.trick.two.presentation.theme.MagicTrickTwoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MagicTrickTwoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        ButtonA()
                        ButtonB()
                    }
                }
            }
        }
    }
}


@Composable
fun ButtonA() {
    Button(onClick = { sendEventA() }, modifier = Modifier.wrapContentSize()) {
        Text(text = "Primary Button")
    }
}


@Composable
fun ButtonB() {
    Button(onClick = { sendEventB() }, modifier = Modifier.wrapContentSize()) {
        Text(text = "Secundary Button")
    }
}

private fun sendEventA() {
    val params = Bundle().apply {
        putString("key1", "value1")
        putInt("key2", 42)
    }

    AnalyticsManager.logEvent(HOME_SCREEN_CLICK_PRIMARY_BUTTON, params)
}

private fun sendEventB() {
    AnalyticsManager.logEvent(HOME_SCREEN_CLICK_SECONDARY_BUTTON)
}
