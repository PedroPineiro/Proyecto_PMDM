package com.pmdm.proyecto_pmdm

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FileCreatorScreen(navController: NavHostController, onSave: (String, String, String) -> Unit) {
    var fileName by remember { mutableStateOf(TextFieldValue("")) }
    var fileExtension by remember { mutableStateOf(TextFieldValue("txt")) }
    var fileContent by remember { mutableStateOf(TextFieldValue("")) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Crear Archivo") },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Volver")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = fileName,
                onValueChange = { fileName = it },
                label = { Text("Nombre del archivo") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = fileExtension,
                onValueChange = { fileExtension = it },
                label = { Text("Extensión del archivo") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = fileContent,
                onValueChange = { fileContent = it },
                label = { Text("Contenido del archivo") },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            val context = LocalContext.current

            Button(
                onClick = {
                    val name = fileName.text.trim()
                    val extension = fileExtension.text.trim()
                    val content = fileContent.text

                    if (name.isEmpty()) {
                        Toast.makeText(
                            context,
                            "Por favor ingresa un nombre para el archivo",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (extension.isEmpty()) {
                        Toast.makeText(
                            context,
                            "Por favor ingresa una extensión para el archivo",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (content.isEmpty()) {
                        Toast.makeText(
                            context,
                            "El contenido no puede estar vacío",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        onSave(name, extension, content)
                    }
                },
                modifier = Modifier.align(Alignment.End)
            ) {
                Text("Guardar Archivo")
            }
        }
    }
}