package com.cookit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cookit.ui.theme.CookitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CookitTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background){
                    RecipeFields("Android")
                }
            }
        }
    }
}

@Composable
fun RecipeFields(name: String) {
    var recipeName by remember { mutableStateOf("")}
    var category by remember { mutableStateOf("")}
    var cuisine by remember { mutableStateOf("")}
    
    Column {
        OutlinedTextField(
            value = recipeName,
            onValueChange = {recipeName = it},
            label = { Text(stringResource(R.string.recipeName))}
        )

        OutlinedTextField(
            value = category,
            onValueChange = {category = it},
            label = { Text(text = stringResource(R.string.category))}
        )

        OutlinedTextField(
            value = cuisine,
            onValueChange = {cuisine = it},
            label = { Text(text = stringResource(R.string.cuisine))}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CookitTheme {
        RecipeFields("Android")
    }
}