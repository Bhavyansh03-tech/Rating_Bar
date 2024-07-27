package com.example.ratingbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.StarHalf
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.StarOutline
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun RatingBar(
    modifier: Modifier = Modifier,
    rating: Double = 0.0,
    stars: Int = 5,
    starsColor: Color = Color.Yellow,
    onRatingChange: (Double) -> Unit
) {
    var isHalfStar = (rating % 1) != 0.0

    Row {
        for (index in 1..stars) {
            Icon(
                modifier = Modifier.clickable { onRatingChange(index.toDouble()) },
                contentDescription = null,
                tint = starsColor,
                imageVector = if (index <= rating) {
                    Icons.Filled.Star
                } else {
                    if (isHalfStar){
                        isHalfStar = false
                        Icons.AutoMirrored.Outlined.StarHalf
                    } else {
                        Icons.Outlined.StarOutline
                    }
                }
            )
        }
    }
}