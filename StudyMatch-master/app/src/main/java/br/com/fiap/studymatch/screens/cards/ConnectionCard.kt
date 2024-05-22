package br.com.fiap.studymatch.screens.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.studymatch.R
import br.com.fiap.studymatch.ui.theme.Kanit
import br.com.fiap.studymatch.ui.theme.backgroundGray
import br.com.fiap.studymatch.ui.theme.terciaryBlue
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun ConnectionCard(
    idImage: String,
    nome: String,
    area: String,
    tempoExp: String,
    habilitys: String,
    email: String
) {


    Card(
        colors = CardDefaults.cardColors(terciaryBlue),
        modifier = Modifier
            .padding(10.dp)
            .width(350.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Card (shape = RoundedCornerShape(topEnd = 0.dp, bottomEnd = 0.dp)){
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(idImage)
                        .crossfade(true)
                        .build(),
                    //placeholder = painterResource(R.drawable.mentor_studymatch),
                    contentDescription = null,
                    modifier = Modifier
                        .width(150.dp)
                        .height(170.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(text = nome, color = Color.White, fontFamily = Kanit)
                Text(text = area, color = Color.White, fontFamily = Kanit)
                Text(
                    text = "$tempoExp anos de experiência",
                    color = Color.White,
                    fontFamily = Kanit
                )
                Text(text = habilitys, color = Color.White, fontFamily = Kanit)
                Text(text = email, color = Color.White, fontFamily = Kanit)
            }
        }

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun ConnectionCardPreview() {
    val listHab = remember { mutableStateListOf<String>("Python", "Django") }

//    listHab.add("Python")
//    listHab.add("Django")
//    listHab.add("AWS")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConnectionCard("https://img.freepik.com/free-photo/man-with-blank-notebook_1187-2304.jpg", "Jorge", "Back-End", "2-4", listHab.toString(), "jorgebenjor@outlook.com")
    }
}