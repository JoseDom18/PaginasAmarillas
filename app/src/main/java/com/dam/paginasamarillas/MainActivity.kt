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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dam.paginasamarillas.ui.theme.PaginasAmarillasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            miPrimerTexto();
            cajaPosicion();
        }
    }
}

@Composable
fun miPrimerTexto(){
    Column (modifier = Modifier.fillMaxSize().padding(top = 32.dp)){
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
        modifier = Modifier.fillMaxSize().padding(32.dp)
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
                    .align(Alignment.CenterVertically).fillMaxSize()
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
