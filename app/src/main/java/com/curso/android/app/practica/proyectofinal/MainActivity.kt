package com.curso.android.app.practica.proyectofinal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.curso.android.app.practica.proyectofinal.ui.theme.ProyectoFinalTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoFinalTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    ComparisonScreen()
                }
            }
        }
    }
}

@Composable
fun ComparisonScreen() {
    var firstString by remember { mutableStateOf("") }
    var secondString by remember { mutableStateOf("") }
    var comparisonResult by remember { mutableStateOf("") }
    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BasicTextField(
            value = firstString,
            onValueChange = { firstString = it },
            keyboardController = keyboardController,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .heightIn(min = 56.dp)
        )
        BasicTextField(
            value = secondString,
            onValueChange = { secondString = it },
            keyboardController = keyboardController,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .heightIn(min = 56.dp)
        )
        Button(
            onClick = {
                comparisonResult = if (firstString == secondString) {
                    "Las cadenas son iguales"
                } else {
                    "Las cadenas son diferentes"
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        ) {
            Text("Comparar")
        }
        Text(
            text = comparisonResult,
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ComparisonScreenPreview() {
    ProyectoFinalTheme {
        ComparisonScreen()
    }
}
