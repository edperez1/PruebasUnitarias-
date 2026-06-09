package ni.edu.uam.pruebasunitarias

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PantallaCalculadora() {
    val calculadora = Calculadora()
    val focusManager = LocalFocusManager.current

    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("Resultado: 0") }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // TextField con acción de "Hecho" para ocultar teclado
        OutlinedTextField(
            value = num1, onValueChange = { num1 = it },
            label = { Text("Número 1") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = num2, onValueChange = { num2 = it },
            label = { Text("Número 2") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(onDone = { focusManager.clearFocus() })
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = resultado, fontSize = 24.sp, modifier = Modifier.testTag("resultado"))

        Spacer(modifier = Modifier.height(32.dp))

        val n1 = num1.toIntOrNull() ?: 0
        val n2 = num2.toIntOrNull() ?: 0

        // Botones de Operación
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(onClick = { resultado = "Suma: ${calculadora.sumar(n1, n2)}" }) { Text("+") }
            Button(onClick = { resultado = "Resta: ${calculadora.restar(n1, n2)}" }) { Text("-") }
            Button(onClick = { resultado = "Mult: ${calculadora.multiplicar(n1, n2)}" }) { Text("*") }
            Button(onClick = { resultado = "Div: ${calculadora.dividir(n1, n2)}" }) { Text("/") }
        }
    }
}