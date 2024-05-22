package br.com.fiap.studymatch.screens.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
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
import br.com.fiap.studymatch.ui.theme.Kanit
import br.com.fiap.studymatch.ui.theme.backgroundGray
import br.com.fiap.studymatch.ui.theme.primaryBlue

@Composable
fun HabilityCard(habilityName: String, onClickCard: () -> Unit ) {
    Card(
        modifier = Modifier.clickable(onClick = onClickCard).padding(top = 10.dp, end = 5.dp),
        colors = CardDefaults.cardColors(primaryBlue),
        shape = RoundedCornerShape(10.dp)
    ) {
    Row(
        modifier = Modifier.padding(7.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = habilityName, color = Color.White, fontSize = 9.sp,  fontFamily = Kanit)
        Image(painter = painterResource(id = R.drawable.close_24), contentDescription = "Simbolo para sair", Modifier.padding(start = 10.dp).size(10.dp))
    }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun HabilityCardPreview() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HabilityCard("Java", {})
    }
}