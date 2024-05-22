package br.com.fiap.studymatch.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.studymatch.R
import br.com.fiap.studymatch.beans.Apprentice
import br.com.fiap.studymatch.beans.Mentor
import br.com.fiap.studymatch.retrofit.RetrofitInit
import br.com.fiap.studymatch.ui.theme.Kanit
import br.com.fiap.studymatch.ui.theme.backgroundGray
import br.com.fiap.studymatch.ui.theme.primaryBlue
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun LoginScreen(navController: NavController) {

    var nameState by remember {
        mutableStateOf("")
    }
    var senhaState by remember {
        mutableStateOf("")
    }

    var apprenticeList = remember {
        mutableStateListOf<Apprentice>()
    }

    var mentorList = remember {
        mutableStateListOf<Mentor>()
    }

    var erroAutentication by remember {
        mutableStateOf(false)
    }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.cap),
            contentDescription = "",
            modifier = Modifier
                .padding(top = 80.dp)
                .size(90.dp)
            )
        Spacer(modifier = Modifier.height(100.dp))
        Text(
            text = "Digite seus dados para entrar",
            color = Color.White,
            fontFamily = Kanit,
            fontSize = 17.sp
        )
        TextField(
            value = nameState,
            isError = erroAutentication,
            onValueChange = { nameState = it },
            modifier = Modifier.padding(20.dp),
            placeholder = { Text(text = "Digite seu usuario", color = Color.White)},
            label = { Text(text = "Usuario", color = Color.White)},
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(focusedContainerColor = primaryBlue, unfocusedContainerColor = primaryBlue)

        )
        TextField(
            value = senhaState,
            isError = erroAutentication,
            onValueChange = { senhaState = it },
            modifier = Modifier.padding(20.dp),
            placeholder = { Text(text = "Digite sua senha", color = Color.White)},
            label = { Text(text = "Senha", color = Color.White)},
            shape = RoundedCornerShape(15.dp),
            colors = TextFieldDefaults.colors(focusedContainerColor = primaryBlue, unfocusedContainerColor = primaryBlue)

        )

//        var callListarMentores = RetrofitInit().getAPIService().getMentors()
//
//        callListarMentores.enqueue(object : Callback<List<Mentor>> {
//            override fun onResponse(call: Call<List<Mentor>>, response: Response<List<Mentor>>) {
//                mentorData = response.body()!!
//            }
//
//            override fun onFailure(call: Call<List<Mentor>>, t: Throwable) {
//                Log.i("ERRO API", "ERRO AO RECUPERAR MENTORES")
//            }
//        })


//        var call = RetrofitInit().getAPIService().getApprentice()
//        call.enqueue(object : Callback<List<Apprentice>>{
//            override fun onResponse(call: Call<List<Apprentice>>, response: Response<List<Apprentice>>) {
//                apprenticeData = response.body()!!
//            }
//
//            override fun onFailure(call: Call<List<Apprentice>>, t: Throwable) {
//                Log.i("ERRO API", "ERRO AO RECUPERAR MENTORES")
//            }
//        })

        Button(
            onClick = {
//                var isAppretince = false
//                var isMentor = false
//                for(app in apprenticeList){
//                if(app.username == nameState && app.senha == senhaState){
//                    navController.navigate("MatchScreen?username=${app.username}&accountType=Apprentice")
//                    isAppretince = true
//                }
//            }
//                for(mentor in mentorList){
//                    if(mentor.username == nameState && mentor.senha == senhaState){
//                        navController.navigate("MatchScreen?username=${mentor.username}&accountType=Mentor")
//                        isMentor = true
//                    }
//                }
//                if(!isAppretince && !isMentor){
//                    erroAutentication = true
//                }

                var username = "vinicius"
                navController.navigate("MatchScreen?username=$username&accountType=Mentor")
            },
            colors = ButtonDefaults.buttonColors(primaryBlue),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(20.dp)
                .height(45.dp)
                .width(150.dp)
        ) {
            Text(text = "Entrar")
        }

        Text(text = "Não possui conta?", color = Color.White, modifier = Modifier.clickable { navController.navigate("SignupScreen") })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    LoginScreen(navController = NavController(LocalContext.current))
}