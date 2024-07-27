# Rating Bar in Jetpack Compose

This repository contains an implementation of a rating bar using Jetpack Compose. The rating bar allows users to select a rating by clicking on stars, with support for half stars.

## Usage

To use the rating bar in your Jetpack Compose project, copy the RatingBar composable function to your project and customize it as needed.

## Screenshot

<img src="https://github.com/user-attachments/assets/d62369d4-38f0-48c7-91f2-e6646ffa6202" alt="First Screenshot" style="width: 200px; height: auto;">

## Getting Started 

### Installation

1. Clone the repository:

   ```sh
     git clone https://github.com/Bhavyansh03-tech/Rating_Bar.git
   ```
   
2. Open the project in Android Studio.
3. Build the project and run it on an emulator or a physical device.

### Rating Bar Implementation
`RatingBar.kt`
```koltin
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
```

`MainActivity.kt`
```kotlin
Column(
modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background),
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
```

### Example
In the `MainActivity`, two examples of the rating bar are shown with different parameters.

1. <b>Rating Bar with 5 stars and a custom color:</b>

- Initial rating: 3.5
- Star color: Red
- Size: 70.dp

2. <b>Rating Bar with 7 stars:</b>

- Initial rating: 5.5
- Star color: Yellow (default)
- Size: 70.dp
- 
Feel free to customize the `RatingBar` parameters such as the number of stars, star color, and size to fit your needs.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/your-feature`).
3. Commit your changes (`git commit -am 'Add some feature'`).
4. Push to the branch (`git push origin feature/your-feature`).
5. Create a new Pull Request.

## Contact

For questions or feedback, please contact [@Bhavyansh03-tech](https://github.com/Bhavyansh03-tech).

---
