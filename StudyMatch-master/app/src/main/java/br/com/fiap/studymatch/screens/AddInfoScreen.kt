package br.com.fiap.studymatch.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.studymatch.R
import br.com.fiap.studymatch.beans.Apprentice
import br.com.fiap.studymatch.beans.Mentor
import br.com.fiap.studymatch.retrofit.RetrofitInit
import br.com.fiap.studymatch.screens.cards.HabilityCard
import br.com.fiap.studymatch.screens.forms.AreaOfInterestForm
import br.com.fiap.studymatch.screens.forms.TimeExperienceForm
import br.com.fiap.studymatch.screens.forms.accountTypeForm
import br.com.fiap.studymatch.ui.theme.Kanit
import br.com.fiap.studymatch.ui.theme.backgroundGray
import br.com.fiap.studymatch.ui.theme.primaryBlue
import br.com.fiap.studymatch.ui.theme.secundaryBlue

@SuppressLint("SuspiciousIndentation")
@Composable
fun AddInfoScreen(
    navController: NavController,
    nome: String,
    usuario: String,
    email: String,
    senha: String
) {

    var urlPhotoState by remember {
        mutableStateOf("")
    }

    var habState by remember {
        mutableStateOf("")
    }
    val listHab = remember { mutableStateListOf<String>() }





    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGray)
            .verticalScroll(ScrollState(0)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "Informações adicionais",
            color = Color.White,
            fontFamily = Kanit,
            fontSize = 32.sp,
            modifier = Modifier.width(300.dp),
            textAlign = TextAlign.Center
        )
        val accountType = accountTypeForm()
        val areaOfInterest = AreaOfInterestForm()
        val timeExperience = TimeExperienceForm()

        TextField(
            value = urlPhotoState,
            onValueChange = { urlPhotoState = it},
            modifier = Modifier
                .padding(20.dp),
            placeholder = {
                Text(
                    text = "Digite a URL da sua foto de perfil",
                    color = Color.White,
                    fontSize = 11.sp,
                    fontFamily = Kanit
                )
            },
            shape = RoundedCornerShape(15.dp),
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = secundaryBlue,
                unfocusedContainerColor = primaryBlue
            )
        )
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            TextField(
                value = habState,
                onValueChange = { habState = it },
                modifier = Modifier
                    .padding(end = 20.dp)
                    .width(200.dp),
                placeholder = {
                    Text(
                        text = "Digite uma habilidade",
                        color = Color.White,
                        fontSize = 11.sp,
                        fontFamily = Kanit
                    )
                },
                textStyle = TextStyle(color = Color.White),
                shape = RoundedCornerShape(15.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = secundaryBlue,
                    unfocusedContainerColor = primaryBlue
                )
            )
            Button(
                onClick = {
                    listHab.add(habState)
                    habState = ""
                          },
                modifier = Modifier
                    .height(55.dp),
                colors = ButtonDefaults.buttonColors(primaryBlue),
                shape = RoundedCornerShape(15.dp)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add_24),
                    contentDescription = "Simbolo de adição",
                )
            }
        }

        LazyRow(
            modifier = Modifier.padding(start = 50.dp, end = 50.dp, bottom = 30.dp)
        ) {
            items(listHab) {
                HabilityCard(it) { listHab.remove(it) }
            }
        }

        var aprendiz = Apprentice(urlPhotoState, nome, usuario, areaOfInterest, timeExperience, listHab.toString().replace("[", "").replace("]", ""), email, senha)
        val mentor = Mentor(urlPhotoState, nome, usuario, areaOfInterest, timeExperience, listHab.toString().replace("[", "").replace("]", ""), email, senha)



        Button(
            onClick = {
//                if(accountType == "Aprendiz") {
//                    RetrofitInit().getAPIService().createApprentice(aprendiz)
//                    navController.navigate("MatchScreen?username=${aprendiz.username}&accountType=Apprentice")
//                }
//                else {
//                    RetrofitInit().getAPIService().createMentor(mentor)
//                    navController.navigate("MatchScreen?username=${mentor.username}&accountType=Mentor")
//                }
                Log.i("Dados Enviados para API", if(accountType == "Aprendiz") aprendiz.toString() else mentor.toString())
                var username = "vinicius"
                navController.navigate("MatchScreen?username=$username&accountType=Mentor")



                      },
            colors = ButtonDefaults.buttonColors(primaryBlue),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Cadastrar",  fontFamily = Kanit)
        }


    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun AddInfoScreenPreview() {
    AddInfoScreen(navController = NavController(LocalContext.current),"Angelo", "AnGabSS", "flkdsj@outlook.com", "345jkdfs")
}