package com.mimo2k.weather.screens

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.mimo2k.weather.R
import com.mimo2k.weather.navigation.WeatherScreens
import kotlinx.coroutines.delay

@Composable
fun  WeatherSplashScreen(navController: NavController){
    Image(painter = painterResource(id = R.drawable.back_splash),
        contentDescription ="wall",
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val scale = remember{
            Animatable(0f)
        }

        LaunchedEffect(key1 = true, block = {
            scale.animateTo(targetValue = 0.8f,
            animationSpec = tween(
                durationMillis = 700,
                easing = {
                    OvershootInterpolator(6f)
                        .getInterpolation(it)
                }
            ))
            delay(1000L)
            navController.navigate(WeatherScreens.MainScreen.name)
        } )


        Surface(
            modifier = Modifier
                .padding(50.dp)
                .size(220.dp)
                .scale(scale.value),
            elevation = 2.dp,
            shape = CircleShape,
            color = colorResource(R.color.sun_color),
            border = BorderStroke(width = 4.dp, color = Color.Yellow)

        ) {

            Column(
                modifier = Modifier.padding(1.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash_sun),
                    contentDescription = "Sunny Icon",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.size(95.dp)
                )
                Text(
                    text = "Find the Sun?",
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Yellow
                )
            }

        }
    }
}