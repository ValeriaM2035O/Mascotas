package com.example.mascotas

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


data class Mascota(val nombre: String, val raza: String, val tamaño: String, val edad: String, val foto: String)


val listaMascotas = mutableStateListOf<Mascota>()

@Composable
fun Registro(navController: NavController) {
    var nombre by rememberSaveable { mutableStateOf("") }
    var raza by rememberSaveable { mutableStateOf("") }
    var tamaño by rememberSaveable { mutableStateOf("") }
    var edad by rememberSaveable { mutableStateOf("") }
    var foto by rememberSaveable { mutableStateOf("") }

    Scaffold(
        containerColor = Color(0xFFD8CAF1),
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Button(
                    onClick = {
                        listaMascotas.add(Mascota(nombre, raza, tamaño, edad, foto))
                        navController.navigate(
                            "Carnet/${Uri.encode(nombre)}/${Uri.encode(raza)}/${Uri.encode(tamaño)}/${Uri.encode(edad)}/${Uri.encode(foto)}"
                        )
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5)),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Check",
                        tint = Color.White
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Registrar", color = Color.White, fontSize = 18.sp)
                }

                Button(
                    onClick = {
                        navController.navigate("Lista")
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5)),
                    shape = RoundedCornerShape(14.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.List,
                        contentDescription = "Lista",
                        tint = Color.White
                    )
                    Spacer(Modifier.width(8.dp))
                    Text("Lista de registros", color = Color.White, fontSize = 18.sp)
                }
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
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color(0xFFB5F3F3)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "\uD83D\uDCCB Formulario de Registro",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF01060A)
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                listOf(
                    "Nombre" to nombre,
                    "Raza" to raza,
                    "Tamaño" to tamaño,
                    "Edad" to edad,
                    "URL Foto" to foto
                ).forEachIndexed { index, pair ->
                    OutlinedTextField(
                        value = pair.second,
                        onValueChange = {
                            when (index) {
                                0 -> nombre = it
                                1 -> raza = it
                                2 -> tamaño = it
                                3 -> edad = it
                                4 -> foto = it
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

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}