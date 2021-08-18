package com.example.composebasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composebasics.ui.theme.ComposeBasicsTheme
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicsTheme {
                // A surface container using the 'background' color from the theme
                MyScreenContent()
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        modifier = Modifier.padding(20.dp)
    )
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Tijo", "JASON")){

    val counterState = remember { mutableStateOf(0) }

    Surface(color = Color.Yellow) {
        Column {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
            Divider(color = Color.Transparent, thickness = 32.dp)
            Counter(
                count = counterState.value,
                updateCount = { newCountValue ->
                    counterState.value = newCountValue
                }
            )
        }
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit){
    Button(onClick = { updateCount(count+1) }) {
        Text(text = "I have been clicked on $count times")
    }
}

@Preview(showBackground = true, name = "SCREEN PREVIEW")
@Composable
fun DefaultPreview() {
    ComposeBasicsTheme {
        MyScreenContent()
    }
}