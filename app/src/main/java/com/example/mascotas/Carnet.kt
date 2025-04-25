package com.example.mascotas

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import coil.compose.AsyncImage
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun Carnet(  navController: NavController,
             nombre: String,
             raza: String,
             tamaño: String,
             edad: String,
             foto: String
) {
    Scaffold(
        containerColor = Color(0xFFD8CAF1),
        bottomBar = {
            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3F51B5)),
                shape = RoundedCornerShape(14.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Volver", color = Color.White, fontSize = 18.sp)
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
                    .padding(16.dp)
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
                        text = "\uD83C\uDF43 \uD83D\uDC3E Carnet de Mascota",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF01060A)
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                AsyncImage(
                    model = foto,
                    contentDescription = "Foto de la mascota",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(160.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .border(3.dp, Color(0xFF3F51B5), RoundedCornerShape(16.dp))
                        .align(Alignment.CenterHorizontally)
                )

                Spacer(modifier = Modifier.height(24.dp))

                Column(modifier = Modifier.padding(start = 12.dp)) {
                    Text("• Nombre: $nombre", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("• Raza: $raza", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("• Tamaño: $tamaño", fontSize = 16.sp)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text("• Edad: $edad", fontSize = 16.sp)
                }
            }
        }
    }
}