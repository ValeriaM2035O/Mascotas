package com.example.mascotas

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaMascotas(navController: NavController) {
    Scaffold(
        containerColor = Color(0xFFD8CAF1),
        topBar = {
            TopAppBar(
                title = { Text(text = "Lista de Mascotas") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF3F51B5),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = {
            Button(
                onClick = {
                    navController.navigate("Registro")
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5)),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Volver a Registro",
                    tint = Color.White
                )
                Spacer(Modifier.width(8.dp))
                Text("Volver a Registro", color = Color.White, fontSize = 18.sp)
            }
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
                    .padding(16.dp)
            ) {
                Text(
                    text = "🐾 Mascotas Registradas",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF01060A),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp),
                    textAlign = TextAlign.Center
                )

                if (listaMascotas.isEmpty()) {
                    Text(
                        text = "No hay mascotas registradas.",
                        fontSize = 16.sp,
                        color = Color.Gray,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        items(listaMascotas) { mascota ->
                            Card(
                                modifier = Modifier.fillMaxWidth(),
                                colors = CardDefaults.cardColors(
                                    containerColor = Color(0xFFB5F3F3)
                                ),
                                shape = RoundedCornerShape(16.dp),
                                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                ) {
                                    Text("🐶 Nombre: ${mascota.nombre}", fontWeight = FontWeight.Bold)
                                    Text("Raza: ${mascota.raza}")
                                    Text("Tamaño: ${mascota.tamaño}")
                                    Text("Edad: ${mascota.edad}")
                                    Text("Foto URL: ${mascota.foto}")

                                    Spacer(modifier = Modifier.height(8.dp))

                                    Row(
                                        modifier = Modifier.fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceEvenly
                                    ) {
                                        Button(
                                            onClick = {
                                                navController.navigate(
                                                    "Actualizar/${mascota.nombre}/${mascota.raza}/${mascota.tamaño}/${mascota.edad}/${mascota.foto}"
                                                )
                                            },
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color(0xFF4CAF50)
                                            )
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Edit,
                                                contentDescription = "Actualizar",
                                                tint = Color.White
                                            )
                                            Spacer(Modifier.width(4.dp))
                                            Text("Actualizar", color = Color.White)
                                        }

                                        Button(
                                            onClick = {
                                                listaMascotas.remove(mascota)
                                            },
                                            colors = ButtonDefaults.buttonColors(
                                                containerColor = Color(0xFFF44336)
                                            )
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.Delete,
                                                contentDescription = "Borrar",
                                                tint = Color.White
                                            )
                                            Spacer(Modifier.width(4.dp))
                                            Text("Borrar", color = Color.White)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}