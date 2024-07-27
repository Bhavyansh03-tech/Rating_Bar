package com.example.ratingbar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ratingbar.ui.theme.RatingBarTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RatingBarTheme {
                Column(
                    modifier = Modifier
                        .fillMaxSize().
                        background(MaterialTheme.colorScheme.background),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    // First Type of RatingBar :->
                    var rating1 by remember {
                        mutableDoubleStateOf(3.5)
                    }

                    RatingBar(
                        modifier = Modifier.size(70.dp),
                        rating = rating1,
                        starsColor = Color.Red
                    ) {
                        rating1 = it
                    }

                    // Second Type of RatingBar with different parameters :->
                    var rating2 by remember {
                        mutableDoubleStateOf(5.5)
                    }

                    RatingBar(
                        modifier = Modifier.size(70.dp),
                        rating = rating2,
                        stars = 7
                    ) {
                        rating2 = it
                    }
                }
            }
        }
    }
}