package ni.edu.uam.pruebasunitarias

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag

@Composable
fun PantallaCalculadora() {
    val calculadora = Calculadora()
    var resultado by remember { mutableStateOf("") }

    Column {
        Button(
            onClick = { resultado = calculadora.sumar(5, 3).toString() }
        ) {
            Text("Sumar")
        }

        Button(
            onClick = { resultado = calculadora.restar(5, 3).toString() }
        ) {
            Text("Restar")
        }

        Text(
            text = resultado,
            modifier = Modifier.testTag("resultado")
        )
    }
}