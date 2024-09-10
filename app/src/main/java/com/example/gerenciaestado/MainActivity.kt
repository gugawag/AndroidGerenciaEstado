package com.example.gerenciaestado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gerenciaestado.ui.theme.GerenciaEstadoTheme
import com.example.gerenciaestado.ui.viewmodels.ContadorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GerenciaEstadoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        ContaNumerosStatefull(
                            modifier = Modifier.padding(innerPadding)
                        )
                        Conta(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ContaNumerosStatefull(modifier: Modifier = Modifier) {
    var contador by remember { mutableIntStateOf(0) }

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Contador Stateful: $contador",
            modifier = modifier
        )
        Button(onClick = { contador++}) {
            Text(text = "Clique aqui")
        }
    }
}

//Stateless
@Composable
fun Conta(modifier: Modifier = Modifier) {
    var contador by remember { mutableIntStateOf(0) }
    ContaNumerosStateless(contador = contador, onIncreaseCount = { contador++ }, modifier)
}

@Composable
fun ContaNumerosStateless(contador: Int,
                          onIncreaseCount: () -> Unit,
                          modifier: Modifier = Modifier) {

    Column(modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "Contador Stateless: $contador",
            modifier = modifier
        )
        Button(onClick = onIncreaseCount) {
            Text(text = "Clique aqui")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GerenciaEstadoTheme {
        Column {
            ContaNumerosStatefull()
            Conta()
        }
    }
}