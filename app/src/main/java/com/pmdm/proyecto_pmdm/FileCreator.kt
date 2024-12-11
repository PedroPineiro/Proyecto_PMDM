package com.pmdm.proyecto_pmdm

import android.content.Context
import android.os.Environment
import android.widget.Toast
import java.io.File
import java.io.FileWriter
import java.io.IOException

class FileCreator(private val context: Context) {
    fun saveTextFile(fileName: String, extension: String, content: String) {
        val dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)
        if (dir != null) {
            val file = File(dir, "$fileName.$extension")

            try {
                val writer = FileWriter(file)
                writer.append(content)
                writer.flush()
                writer.close()

                Toast.makeText(context, "Archivo guardado en: ${file.absolutePath}", Toast.LENGTH_LONG)
                    .show()
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(context, "Error al guardar el archivo", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(context, "No se pudo acceder al almacenamiento", Toast.LENGTH_SHORT).show()
        }
    }
}