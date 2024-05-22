package br.com.fiap.studymatch.screens.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.studymatch.R
import br.com.fiap.studymatch.ui.theme.backgroundGray
import br.com.fiap.studymatch.ui.theme.terciaryBlue

@Composable
fun NoMoreProfilesCard() {
    Column(
        modifier = Modifier
            .background(backgroundGray)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cap),
            contentDescription = "StudyMatch logo",
            modifier = Modifier
                .padding(top = 10.dp)
                .size(30.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 50.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Image(
                painter = painterResource(id = R.drawable.group),
                contentDescription = "Simbolo de grupo"
            )
            Image(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Simbolo de filtro"
            )
        }
        Column(
            modifier = Modifier
                .width(300.dp)
                .fillMaxHeight(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                colors = CardDefaults.cardColors(terciaryBlue),
            ) {
                Column (
                    modifier = Modifier
                        .height(600.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(
                        "Sem mais perfis para mostra :(",
                        fontSize = 30.sp,
                        color = Color.White,
                        modifier = Modifier.padding(20.dp)
                    )
                }

            }
        }
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NoMoreProfilesPreview() {
    NoMoreProfilesCard()
}