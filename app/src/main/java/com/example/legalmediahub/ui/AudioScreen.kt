package com.example.legalmediahub.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AudioScreen() {
    var status by remember { mutableStateOf("Selecciona un archivo local para convertir a MP3.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Conversión a MP3", style = MaterialTheme.typography.headlineSmall)
        Text(
            "Esta base está orientada a audio local o contenido con licencia. " +
                "Para plataformas con términos específicos (ej. YouTube), respeta sus políticas.",
            style = MaterialTheme.typography.bodyMedium
        )

        Button(onClick = {
            status = "Flujo base listo: integra FFmpeg/MediaCodec para convertir archivos locales a MP3."
        }) {
            Text("Preparar conversión")
        }

        Text(status)
    }
}
