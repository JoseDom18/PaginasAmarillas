package com.dam.paginasamarillas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dam.paginasamarillas.ui.theme.PaginasAmarillasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PaginasAmarillasTheme {
                // 1. Lógica de navegación principal
                var showLoginScreen by rememberSaveable { mutableStateOf(true) }

                if (showLoginScreen) {
                    LoginScreen(onRegisterClick = { showLoginScreen = false })
                } else {
                    RegistroScreen(onBackToLogin = { showLoginScreen = true })
                }
            }
        }
    }
}

@Composable
fun LoginScreen(onRegisterClick: () -> Unit) {

    // Estados para los campos de texto. Usamos rememberSaveable para sobrevivir a giros de pantalla.
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var showPassword by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo de un pulpo amarillo con herramientas dentro de una casa",
            modifier = Modifier
                .size(160.dp)
                .clip(RoundedCornerShape(64.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(32.dp))

        // --- Campo de texto para el Email ---
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(stringResource(id = R.string.correo_electronico)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // --- Campo de texto para la Contraseña con OutlinedTextField ---
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(stringResource(id = R.string.password)) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            // Oculta o muestra el texto de la contraseña
            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            // Mejora para accesibilidad en teclados
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            // Icono para cambiar la visibilidad
            trailingIcon = {
                val image = if (showPassword) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (showPassword) "Ocultar contraseña" else "Mostrar contraseña"

                IconButton(onClick = { showPassword = !showPassword }) {
                    Icon(imageVector = image, contentDescription = description)
                }
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* TODO: Lógica de inicio de sesión */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(R.string.iniciar_sesi_n))
        }

        Spacer(modifier = Modifier.height(32.dp))

        // --- Texto Clicable para ir al Registro ---
        val annotatedText = buildAnnotatedString {
            append(stringResource(R.string.no_tienes_cuenta))
            pushLink(
                LinkAnnotation.Clickable(
                    tag = "REGISTRO",
                    linkInteractionListener = { onRegisterClick() } // Llama a la función de navegación
                )
            )
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary, // Usa el color del tema
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            ) {
                append(stringResource(R.string.registrate))
            }
            pop()
        }

        Text(text = annotatedText)
    }
}

@Composable
fun RegistroScreen(onBackToLogin: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Pantalla de Registro", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = onBackToLogin) {
            Text("Volver al Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    PaginasAmarillasTheme {
        LoginScreen(onRegisterClick = {})
    }
}

@Preview(showBackground = true)
@Composable
fun RegistroPreview() {
    PaginasAmarillasTheme {
        RegistroScreen(onBackToLogin = {})
    }
}
