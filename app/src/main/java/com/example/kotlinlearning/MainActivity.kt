package com.example.kotlinlearning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kotlinlearning.ui.theme.KotlinLearningTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinLearningTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Content(
                        message = stringResource(R.string.textContent1),
                        from = "From Emma",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Content(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)
    Column(modifier = modifier) {
        Box(modifier = modifier) {
            Image(
                painter = image,
                contentDescription = null,
            )
        }
        ContentHeading("Jetpack Compose tutorial")
        ContentText(
            messages = arrayOf(
                stringResource(R.string.textContent1),
                stringResource(R.string.textContent2)
            ),
            modifier = Modifier
//            .fillMaxSize()
//            .padding(8.dp)
        )
    }
}

@Composable
fun ContentHeading(content: String, modifier: Modifier = Modifier) {
    Text(content, fontSize = 24.sp, modifier = modifier.padding(16.dp))
}

@Composable
fun ContentText(messages: Array<String>, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
    ) {


        messages.forEach { item ->
            Text(
                text = item,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = modifier.padding(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    KotlinLearningTheme {
        Content(
            message = stringResource(R.string.textContent1),
            from = stringResource(R.string.textContent2),
        )
    }
}