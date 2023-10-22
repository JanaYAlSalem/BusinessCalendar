package com.example.businesscalendar.features.feature_splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.businesscalendar.R
import com.example.businesscalendar.core.presentation.navigation.AppScreens
import com.example.businesscalendar.core.presentation.ui.theme.Blue30
import com.example.businesscalendar.core.presentation.ui.theme.Blue40

@Composable
fun  SplashScreen (
    navController: NavController
) {

    ConstraintLayout(
        modifier = Modifier
            .background(color = Color(0xFFFFFFFF))
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val interactionSource = MutableInteractionSource()
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState()),
        ) {
            BuildLogoImage()
            BuildAppName()
            Button(onClick = { navController.navigate(AppScreens.CalendarHomeScreen.route) }) {
                Text(text = "Start")
            }
        }
    }
}

@Composable
private fun BuildLogoImage() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.app_icon))
    val progress by animateLottieCompositionAsState(
        composition, iterations = LottieConstants.IterateForever
    )

    Row(Modifier.padding(bottom = 32.dp, top = 72.dp)) {
        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.size(400.dp)
        )
    }
}

@Composable
private fun BuildAppName() {
    Text(text = "Business Calendar",
            style = TextStyle(
            fontSize = 24.sp,
                color = Blue30,
                fontWeight = FontWeight.Bold

        )
    )
}
