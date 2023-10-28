package com.example.businesscalendar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.ui.platform.LocalContext
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.businesscalendar.ui.commen.MainScaffold
import com.example.businesscalendar.ui.commen.SplashViewModel
import com.example.businesscalendar.ui.theme.BusinessCalendarTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel:SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            viewModel.isLoading.value
        }
        setContent {
            val context = LocalContext.current

            BusinessCalendarTheme {
                MainScaffold()
            }
        }
    }
}
