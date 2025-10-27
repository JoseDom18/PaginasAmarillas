package com.dam.paginasamarillas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.paginasamarillas.ui.theme.PaginasAmarillasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            miPrimerTexto();
//            cajaPosicion();
            login();
        }

    }
}

@Composable
fun miPrimerTexto(){
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(top = 32.dp)){
        Row {
            Text("")
            Text(text = "Esto es una fila1")
            Spacer(modifier = Modifier.width(16.dp))
            Column {
                Text(text = "Esto es una columna")
                Text(text = "Esto es una Columna2")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = "Esto es una fila2")

        }

        Spacer(modifier = Modifier.height(32.dp))

        Text(text = "Paginas Amarillas");
        Text(text = "Bienvenido");
    }
}

@Composable
fun cajaPosicion(){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ){
        Row(
            modifier = Modifier
                .padding(8.dp)
                .size(50.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.elpunto),
                contentDescription = "Esta es mi tienda el punto en estilo pixel art",
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxSize()
                    .size(20.dp)
                    .clip(CircleShape)
            )

            Column (
                modifier = Modifier
                    .background(Color.Red)
                    .fillMaxSize()
                    .align(Alignment.Top)
            ) {
                Text(
                    text = "Tienda el punto",
                    modifier = Modifier
                        .align(Alignment.End)
                        .fillMaxSize()
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun miPrimerPreview(){
    miPrimerTexto();
}

@Preview(showBackground = true)
@Composable
fun previewBoxImagen(){
    cajaPosicion();
}

@Composable
fun login(){
    var email : String by remember { mutableStateOf("") };
    var password : String by remember { mutableStateOf("") };
    Box(
        modifier = Modifier
            .padding(all = 50.dp)
    ){
            Text(
                text = stringResource(R.string.bienvenido_a_p_ginas_amarillas),
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .align(Alignment.TopCenter)


            )
        Column {

            OutlinedTextField(
                value = email,
                onValueChange = { email = it},
                label = {Text(stringResource(R.string.correo_electronico))},
                modifier = Modifier
                    .padding(top = 20.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it},
                label = {Text(stringResource(R.string.password))},
                modifier = Modifier
                    .padding(top = 20.dp)
            )

            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 15.dp)
            ) {
                Text(
                    text = stringResource(R.string.iniciar_sesi_n)
                )
            }

        }
    }

}

@Preview(showBackground = true)
@Composable
fun loginP(){
    login();
}