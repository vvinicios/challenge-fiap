package br.com.fiap.studymatch.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.studymatch.beans.Apprentice
import br.com.fiap.studymatch.beans.Mentor
import br.com.fiap.studymatch.retrofit.RetrofitInit
import br.com.fiap.studymatch.screens.cards.ConnectionCard
import br.com.fiap.studymatch.ui.theme.Kanit
import br.com.fiap.studymatch.ui.theme.backgroundGray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun ConnectionsScreenApprentice(navController: NavController, username: String) {

    var listConnection by remember {
        mutableStateOf(listOf<Mentor>())
    }

    var callListarMentores = RetrofitInit().getAPIService().getMatchsApprentice(username)

    callListarMentores.enqueue(object : Callback<List<Mentor>>{
        override fun onResponse(call: Call<List<Mentor>>, response: Response<List<Mentor>>) {
            listConnection = response.body()!!
        }

        override fun onFailure(call: Call<List<Mentor>>, t: Throwable) {
            Log.i("ERRO API", "ERRO AO RECUPERAR MENTORES")
        }
    })



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Conexões",
            fontSize = 30.sp,
            fontFamily = Kanit,
            color = Color.White,
            modifier = Modifier.padding(30.dp)
        )
        LazyColumn {
            items(listConnection) {
                ConnectionCard(
                    idImage = it.idImage,
                    nome = it.nome,
                    area = it.area,
                    tempoExp = it.tempoExp,
                    habilitys = it.habilitys,
                    email = it.email
                )
            }
        }


    }
}

@Preview(showBackground = true)
@Composable
private fun ConnectionsScreenPreview() {
    val listJorge = remember {
        mutableStateListOf<String>()
    }
    listJorge.add("Python")
    listJorge.add("Django")
    listJorge.add("AWS")
    val listMaria = remember {
        mutableStateListOf<String>()
    }
    listMaria.add("IOS")
    listMaria.add("Swift")
    val listGiovanna = remember {
        mutableStateListOf<String>()
    }
    listGiovanna.add("Linux")
    listGiovanna.add("AWS")
    listGiovanna.add("Kafka")

    val listApprentice = remember {
        mutableStateListOf<Apprentice>()
    }

    listApprentice.add(Apprentice(
            "https://img.freepik.com/free-photo/man-with-blank-notebook_1187-2304.jpg",
            "Jorge",
            "Jorge ben jor",
            "Back-End",
            "2-4",
            listJorge.toString(),
            "jorgebenjor@outlook.com")
    )

    listApprentice.add(Apprentice(
        idImage = "https://img.freepik.com/fotos-gratis/estudante-bela-jovem-africana-feliz-segurando-cadernos_171337-14002.jpg?size=626&ext=jpg&ga=GA1.1.34264412.1706054400&semt=ais",
        nome = "Maria",
        username = "Maria",
        area = "Mobile",
        tempoExp = "0-1",
        habilitys = listMaria.toString(),
        email = "mariabeth@gmail.com"
    ))

    listApprentice.add(Apprentice(
        "https://img.freepik.com/psd-gratuitas/retrato-de-estudio-de-uma-jovem-estudante-adolescente_23-2150162514.jpg",
        "Giovanna",
        "GioSeattle",
        "DevOps",
        "5-7",
        listGiovanna.toString(),
        "gioseattle@outlook.com"
    )
    )

    ConnectionsScreenApprentice(navController = NavController(LocalContext.current), "listApprentice")
}