package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpaceApp()
                }
            }
        }
    }
}

@Composable
fun ArtSpaceApp() {
    var result by remember { mutableStateOf(1) }

    val art = when (result) {
        1 -> {
            ArtToDisplay(
                image = R.drawable.art_1,
                title = R.string.art_title_1,
                artist = R.string.art_artist_1,
                year = R.string.art_year_1
            )
        }
        2 -> {
            ArtToDisplay(
                image = R.drawable.art_2,
                title = R.string.art_title_2,
                artist = R.string.art_artist_2,
                year = R.string.art_year_2
            )
        }
        3 -> {
            ArtToDisplay(
                image = R.drawable.art_3,
                title = R.string.art_title_3,
                artist = R.string.art_artist_3,
                year = R.string.art_year_3
            )
        }
        else -> println("Error")
    }
}

@Composable
fun ArtToDisplay(image: Int, title: Int, artist: Int, year: Int) {
    Column(
        modifier = Modifier
            .padding(15.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box (
            modifier = Modifier
                .heightIn(400.dp, 430.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        ){
            Image(
                painter = painterResource(id = image),
                contentDescription = stringResource(id = title),
                modifier = Modifier
                    .border(2.dp, Color.Black, RectangleShape)
                    .padding(15.dp)
            )
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = stringResource(id = title),
                fontSize = 30.sp,
                fontFamily = FontFamily.SansSerif
            )
            Text(
                text = stringResource(id = artist) + ", " + stringResource(id = year),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontStyle = androidx.compose.ui.text.font.FontStyle.Italic
            )
        }

        Column(
          modifier = Modifier
              .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ){
            Spacer(modifier = Modifier.weight(1f))
            Row(modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.Bottom
            ){
                Button(modifier = Modifier
                    .height(50.dp)
                    .width(150.dp),
                    onClick = {}
                ){
                    Text(
                        text = stringResource(id = R.string.previous),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }
                Button(modifier = Modifier
                    .height(50.dp)
                    .width(150.dp),
                    onClick = {}
                ){
                    Text(
                        text = stringResource(id = R.string.next),
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
        }
    }
}

// Create a composable function named Buttons Layout
@Composable
fun ButtonsLayout(
    modifierButton: Modifier,
    onClickPrevious: () -> Unit,
    onClickNext: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(top=300.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.weight(1f))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 25.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = onClickPrevious,
                modifier = modifierButton
            ) {
                Text(
                    text = stringResource(id = R.string.previous),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif
                )
            }
            Button(
                onClick = onClickNext,
                modifier = modifierButton
            ) {
                Text(
                    text = stringResource(id = R.string.next),
                    fontSize = 20.sp,
                    fontFamily = FontFamily.SansSerif
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtSpaceLayoutPreview() {
    ArtSpaceTheme {
        ArtSpaceApp()
    }
}