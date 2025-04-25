package com.example.mascotas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Actualizar(
    navController: NavController,
    nombre: String,
    raza: String,
    tamaño: String,
    edad: String,
    foto: String
) {
    var nombreState by rememberSaveable { mutableStateOf(nombre) }
    var razaState by rememberSaveable { mutableStateOf(raza) }
    var tamañoState by rememberSaveable { mutableStateOf(tamaño) }
    var edadState by rememberSaveable { mutableStateOf(edad) }
    var fotoState by rememberSaveable { mutableStateOf(foto) }

    Scaffold(
        containerColor = Color(0xFFD8CAF1),
        topBar = {
            TopAppBar(
                title = { Text(text = "Actualizar Mascota") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3F51B5),
                    titleContentColor = Color.White
                )
            )
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            shape = RoundedCornerShape(24.dp),
            shadowElevation = 10.dp,
            color = Color(0xFFFDFDFD)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                listOf(
                    "Nombre" to nombreState,
                    "Raza" to razaState,
                    "Tamaño" to tamañoState,
                    "Edad" to edadState,
                    "URL Foto" to fotoState
                ).forEachIndexed { index, pair ->
                    OutlinedTextField(
                        value = pair.second,
                        onValueChange = {
                            when (index) {
                                0 -> nombreState = it
                                1 -> razaState = it
                                2 -> tamañoState = it
                                3 -> edadState = it
                                4 -> fotoState = it
                            }
                        },
                        label = { Text(pair.first) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        shape = RoundedCornerShape(12.dp),
                        singleLine = true
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val updatedMascota = Mascota(
                            nombreState, razaState, tamañoState, edadState, fotoState
                        )
                        listaMascotas[listaMascotas.indexOfFirst { it.nombre == nombre }] = updatedMascota
                        navController.popBackStack()
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5)),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Text("Actualizar", color = Color.White)
                }
            }
        }
    }
}