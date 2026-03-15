package com.example.legalmediahub.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PdfEditorScreen() {
    var noteText by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("Cargar PDF y exportar copia anotada.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Editor PDF", style = MaterialTheme.typography.headlineSmall)
        Text(
            "Plantilla base para edición: puedes conectar selector de archivo y render con PdfRenderer.",
            style = MaterialTheme.typography.bodyMedium
        )

        OutlinedTextField(
            value = noteText,
            onValueChange = { noteText = it },
            label = { Text("Texto de anotación") }
        )

        Button(onClick = {
            status = if (noteText.isBlank()) {
                "Escribe texto para anotar el PDF."
            } else {
                "Anotación preparada: '$noteText'. Integra exportación con PdfDocument."
            }
        }) {
            Text("Aplicar anotación")
        }

        Text(status)
    }
}
