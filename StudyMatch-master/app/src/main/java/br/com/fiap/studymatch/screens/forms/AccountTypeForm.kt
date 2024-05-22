package br.com.fiap.studymatch.screens.forms

import android.widget.Space
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
fun accountTypeForm(): String{

    var mentorSelected by remember {
        mutableStateOf(true)
    }

    Spacer(modifier = Modifier.height(20.dp))
    Text(text = "Tipo de conta", color = Color.White, fontFamily = Kanit)
    Row (
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Row (
            modifier = Modifier.width(130.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(selected = mentorSelected, onClick = { mentorSelected = true})
            Text(text = "Mentor", color = Color.White,  fontFamily = Kanit)
        }
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            RadioButton(selected = !mentorSelected, onClick = { mentorSelected = false })
            Text(text = "Aprendiz", color = Color.White,  fontFamily = Kanit)
        }
    }
    return if (mentorSelected){
        "Mentor"
    } else{
        "Aprendiz"
    }
}