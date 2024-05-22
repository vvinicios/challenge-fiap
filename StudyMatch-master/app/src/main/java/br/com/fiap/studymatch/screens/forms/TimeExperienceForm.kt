package br.com.fiap.studymatch.screens.forms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.unit.dp
import br.com.fiap.studymatch.ui.theme.Kanit

@Composable
fun TimeExperienceForm(): String {

    var timeExperience by remember{
        mutableStateOf("0-1")
    }
    Spacer(modifier = Modifier.height(10.dp))
    Text(text = "Tempo de experiência na área em anos", color = Color.White,  fontFamily = Kanit)
    Row (
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(selected = if (timeExperience == "0-1") true else false, onClick = { timeExperience = "0-1" })
            Text(text = "0-1", color = Color.White, fontFamily = Kanit)
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(selected = if (timeExperience == "2-4") true else false, onClick = { timeExperience = "2-4" })
            Text(text = "2-4", color = Color.White, fontFamily = Kanit)
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(selected = if (timeExperience == "5-7") true else false, onClick = { timeExperience = "5-7" })
            Text(text = "5-7", color = Color.White, fontFamily = Kanit)
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(selected = if (timeExperience == "8 ou mais") true else false, onClick = { timeExperience = "8 ou mais" })
            Text(text = "8 ou mais", color = Color.White, fontFamily = Kanit)
        }
    }
    return timeExperience
}
