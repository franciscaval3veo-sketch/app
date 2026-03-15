# LegalMediaHub (Android)

Aplicación Android de ejemplo enfocada en **descargas legales** y utilidades de documentos.

## Qué incluye

- Descarga de archivos de video/audio desde URLs **directas** con `DownloadManager`.
- Conversión a MP3 de audio local (flujo preparado en UI; requiere integrar motor FFmpeg/MediaCodec según necesidad).
- Herramienta base para PDF:
  - seleccionar un PDF,
  - agregar texto de anotación,
  - exportar una copia anotada.

## Límites importantes

- No incluye bypass de DRM, paywalls o medidas técnicas de plataformas.
- No incluye extracción no autorizada de contenido de YouTube/TikTok u otras plataformas.
- No incluye eliminación automática de marcas de agua de terceros.

> Usa la app solo con contenido propio o con licencia/autorización.

## Estructura

- `app/src/main/java/com/example/legalmediahub/MainActivity.kt`: navegación principal.
- `app/src/main/java/com/example/legalmediahub/ui/DownloadScreen.kt`: descargas legales.
- `app/src/main/java/com/example/legalmediahub/ui/PdfEditorScreen.kt`: edición básica de PDF.
- `app/src/main/java/com/example/legalmediahub/ui/AudioScreen.kt`: conversión local a MP3 (base).

## Compilación

```bash
./gradlew :app:assembleDebug
```

Requiere Android SDK instalado.
