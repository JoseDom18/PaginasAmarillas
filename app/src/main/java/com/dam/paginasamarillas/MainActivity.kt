package com.dam.paginasamarillas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp
import com.dam.paginasamarillas.ui.theme.PaginasAmarillasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            login();
        }
    }
}

@Composable
fun login(){

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo de un pulpo amarillo con herramientas dentro de una casa",
            modifier = Modifier
                .size(160.dp)
                .clip(RoundedCornerShape(64.dp)),
            contentScale = ContentScale.Crop
        )

        Spacer(
            modifier = Modifier
                .height(32.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text(stringResource(id = R.string.correo_electronico))},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text(stringResource(id = R.string.password))},
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
        )

        Spacer(
            modifier = Modifier
                .height(16.dp)
        )

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Text(text = stringResource(R.string.iniciar_sesi_n))
        }

        Spacer(
            modifier = Modifier
                .height(32.dp)
        )

        val textoAnotado = buildAnnotatedString {
            append(stringResource(R.string.no_tienes_cuenta))
            pushStringAnnotation(tag = "REGISTRATE", annotation = "REGISTRATE")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            ) {
                append(stringResource(R.string.registrate))
            }
            pop()
        }

        Text(
            text = textoAnotado,
        )

    }

}

@Preview(showBackground = true)
@Composable
fun pLogin(){
    login();
}
