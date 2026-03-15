package com.example.legalmediahub.ui

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun DownloadScreen() {
    val context = LocalContext.current
    var url by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("Pega un enlace directo a un archivo de video/audio autorizado.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Descargas legales",
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = "La app no elimina marcas de agua ni evade restricciones de plataformas.",
            style = MaterialTheme.typography.bodyMedium
        )
        OutlinedTextField(
            value = url,
            onValueChange = { url = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("URL directa") },
            singleLine = true
        )
        Button(
            onClick = {
                message = if (url.startsWith("http")) {
                    val id = enqueueDownload(context, url)
                    "Descarga iniciada. ID: $id"
                } else {
                    "La URL no es válida."
                }
            }
        ) {
            Text("Descargar")
        }
        Text(text = message)
    }
}

private fun enqueueDownload(context: Context, url: String): Long {
    val request = DownloadManager.Request(Uri.parse(url)).apply {
        setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, Uri.parse(url).lastPathSegment)
        setTitle("Descarga LegalMediaHub")
    }
    val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    return downloadManager.enqueue(request)
}
