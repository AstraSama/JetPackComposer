package com.example.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeTutorialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        titulo = "Jetpack Compose tutorial",
                        texto1 = "Jetpack Compose is a modern toolkit for building native Android UI. Compose simplifies and accelerates UI development on Android with less code, powerful tools, and intuitive Kotlin APIs.",
                        texto2 = "In this tutorial, you build a simple UI component with declarative functions. You call Compose functions to say what elements you want and the Compose compiler does the rest. Compose is built around Composable functions. These functions let you define your app\\'s UI programmatically because they let you describe how it should look and provide data dependencies, rather than focus on the process of the UI\\'s construction, such as initializing an element and then attaching it to a parent. To create a Composable function, you add the @Composable annotation to the function name."

                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(titulo: String, texto1: String, texto2: String, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
            .background(Color.LightGray)
            .padding(16.dp)
            .verticalScroll(scrollState)// Padding for the entire Column
    ) {
        Text(
            text = titulo,
            fontSize = 24.sp,
            modifier = Modifier
                .padding(16.dp)
                // Padding for the title
        )
        Text(
            text = texto1,
            modifier = Modifier
                .fillMaxWidth() // Occupy full width
                .padding(horizontal = 16.dp) // Padding left and right

        )
        Text(
            text = texto2,
            modifier = Modifier.padding(16.dp) // Padding for the last text
        )
    }
}

@Composable
fun GreetingImage(titulo: String, texto1: String, texto2: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = (R.drawable.pexels_markusspiske_225250))

    Box(modifier) {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        GreetingText(
            titulo = titulo,
            texto1 = texto1,
            texto2 = texto2,
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 100.dp, 0.dp, 0.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun JetPackComposeTutorialPreview() {
    JetpackComposeTutorialTheme {
        GreetingImage(
            titulo = "me diga então",
            texto1 = "me di213ga então",
            texto2 = "o que eu sou"
            )
    }
}