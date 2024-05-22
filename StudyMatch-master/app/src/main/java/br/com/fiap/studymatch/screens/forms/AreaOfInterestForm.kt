package br.com.fiap.studymatch.screens.forms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.fiap.studymatch.ui.theme.Kanit
import br.com.fiap.studymatch.ui.theme.backgroundGray

@Composable
fun AreaOfInterestForm(): String{

    var opcaoEscolhida by remember{
        mutableStateOf("")
    }

    Spacer(modifier = Modifier.height(10.dp))
    Text(text = "Selecione sua área de interesse", color = Color.White, fontFamily = Kanit)
    Row (
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(selected = opcaoEscolhida == "Back-end", onClick = { opcaoEscolhida = "Back-end" })
                Text(text = "Back-end", color = Color.White, fontFamily = Kanit)
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(selected = opcaoEscolhida == "Front-end", onClick = { opcaoEscolhida = "Front-end" })
                Text(text = "Front-end", color = Color.White, fontFamily = Kanit)
            }
        }
        Column {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(selected = opcaoEscolhida == "FullStack", onClick = { opcaoEscolhida = "FullStack" })
                Text(text = "FullStack", color = Color.White,  fontFamily = Kanit)
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(selected = opcaoEscolhida == "DevOps", onClick = { opcaoEscolhida = "DevOps" })
                Text(text = "DevOps", color = Color.White,  fontFamily = Kanit)
            }
        }
        Column {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(selected = opcaoEscolhida == "Data Science", onClick = { opcaoEscolhida = "Data Science" })
                Text(text = "Data Science", color = Color.White,  fontFamily = Kanit)
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                RadioButton(selected = opcaoEscolhida == "Mobile", onClick = { opcaoEscolhida = "Mobile" })
                Text(text = "Mobile", color = Color.White,  fontFamily = Kanit)
            }
        }


    }
    return opcaoEscolhida
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun AreaOfInterestFormPreview() {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AreaOfInterestForm()
    }
}
