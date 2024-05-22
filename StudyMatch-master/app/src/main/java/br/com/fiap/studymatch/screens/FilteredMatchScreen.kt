package br.com.fiap.studymatch.screens

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import br.com.fiap.studymatch.beans.Apprentice
import br.com.fiap.studymatch.beans.Mentor
import br.com.fiap.studymatch.beans.User
import br.com.fiap.studymatch.functions.findMatches
import br.com.fiap.studymatch.retrofit.RetrofitInit
import br.com.fiap.studymatch.screens.cards.MatchCard
import br.com.fiap.studymatch.screens.cards.NoMoreProfilesCard
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun FilteredMatchScreen(
    navController: NavController,
    currentUser: User,
    areaOfInterest: String,
    timeExperience: String,
) {

    val listHab = listOf("Python", "Django", "AWS")

    var currentIndex by remember { mutableStateOf(0) }
    var likedPairs by remember { mutableStateOf(mutableListOf<Pair<Mentor, Apprentice>>()) }

    var apprenticeData by remember {
        mutableStateOf(Apprentice())
    }

    var mentorData by remember {
        mutableStateOf(Mentor())
    }

    var mentor = Mentor(
        "1234",
        "Angelo",
        "AnGabSS",
        "Mobile",
        "2-4",
        listHab.toString().replace("[", "").replace("]", ""),
        "angelo@outlook.com",
        "1355"
    )

    /*if (currentUser.accountType == "Aprendiz") {
        val call = RetrofitInit().getAPIService().getApprenticeByUsername(currentUser.username)
        call.enqueue(object : Callback<Apprentice> {
            override fun onResponse(call: Call<Apprentice>, response: Response<Apprentice>) {
                apprenticeData = response.body()!!
            }

            override fun onFailure(call: Call<Apprentice>, t: Throwable) {
                Log.i("ERRO API", "ERRO AO RECUPERAR APRENDIZ")
            }
        })
    } else if (currentUser.accountType == "Mentor") {
        val call = RetrofitInit().getAPIService().getMentorsByUsername(currentUser.username)
        call.enqueue(object : Callback<Mentor> {
            override fun onResponse(call: Call<Mentor>, response: Response<Mentor>) {
                mentorData = response.body()!!
            }

            override fun onFailure(call: Call<Mentor>, t: Throwable) {
                Log.i("ERRO API", "ERRO AO RECUPERAR APRENDIZ")

            }
        })
    }*/

    if (currentUser.accountType == "Aprendiz") {

        var profiles by remember {
            mutableStateOf(listOf<Mentor>())
        }

        var callListarMentores = RetrofitInit().getAPIService()
            .getMentorWithAdvancedSearch(areaOfInterest, timeExperience)

        callListarMentores.enqueue(object : Callback<List<Mentor>> {
            override fun onResponse(call: Call<List<Mentor>>, response: Response<List<Mentor>>) {
                profiles = response.body()!!
            }

            override fun onFailure(call: Call<List<Mentor>>, t: Throwable) {
                Log.i("ERRO API", "ERRO AO RECUPERAR MENTORES")
            }
        })

        if (currentIndex < profiles.size) {
            MatchCard(
                user = currentUser,
                profile = profiles[currentIndex],
                onLike = {
                    likedPairs.add(profiles[currentIndex] to apprenticeData)
                    currentIndex++
                },
                onDislike = { currentIndex++ },
                navController = navController
            )
        } else {
            NoMoreProfilesCard()
        }
    }

    if (currentUser.accountType == "Mentor") {

        val aprendizes = listOf(
            Apprentice(
                "https://img.freepik.com/free-photo/man-with-blank-notebook_1187-2304.jpg",
                "Angelo",
                "AnGabSS",
                "Mobile",
                "2-4",
                listHab.toString().replace("[", "").replace("]", ""),
                "angelo@outlook.com",
                "1355"
            ),
            Apprentice(
                "https://img.freepik.com/psd-gratuitas/retrato-de-estudio-de-uma-jovem-estudante-adolescente_23-2150162514.jpg",
                "Giovanna",
                "gioseattle",
                "DevOps",
                "4-7",
                listHab.toString().replace("[", "").replace("]", ""),
                "gi@outlook.com",
                "1784"
            ),
            Apprentice(
                "https://img.freepik.com/free-photo/serious-pensive-young-student-looking-directly-camera_176532-8154.jpg?size=626&ext=jpg&ga=GA1.1.2008272138.1712880000&semt=ais",
                "Diogo",
                "tsumikage",
                "Front-End",
                "0-1",
                listHab.toString().replace("[", "").replace("]", ""),
                "diogo@outlook.com",
                "2564"
            ),
            Apprentice(
                "https://img.freepik.com/free-photo/man-with-blank-notebook_1187-2304.jpg",
                "Bruno",
                "Brunin",
                "Mobile",
                "2-4",
                listHab.toString().replace("[", "").replace("]", ""),
                "brunizor@outlook.com",
                "1355"
            ),
            Apprentice(
                "https://img.freepik.com/psd-gratuitas/retrato-de-estudio-de-uma-jovem-estudante-adolescente_23-2150162514.jpg",
                "Julia",
                "juleaks",
                "Mobile",
                "2-4",
                listHab.toString().replace("[", "").replace("]", ""),
                "juleaks@outlook.com",
                "1784"
            ),
            Apprentice(
                "https://img.freepik.com/free-photo/serious-pensive-young-student-looking-directly-camera_176532-8154.jpg?size=626&ext=jpg&ga=GA1.1.2008272138.1712880000&semt=ais",
                "Cleiton",
                "cleitonJ",
                "Front-End",
                "0-1",
                listHab.toString().replace("[", "").replace("]", ""),
                "cleitonj2010@outlook.com",
                "2564"
            )
        )

        var profiles =
            aprendizes.filter { p -> p.area == areaOfInterest && p.tempoExp == timeExperience }


//        var call = RetrofitInit().getAPIService().getApprenticeWithAdvancedSearch(areaOfInterest, timeExperience)
//        call.enqueue(object : Callback<List<Apprentice>>{
//            override fun onResponse(call: Call<List<Apprentice>>, response: Response<List<Apprentice>>) {
//                profiles = response.body()!!
//            }
//
//            override fun onFailure(call: Call<List<Apprentice>>, t: Throwable) {
//                Log.i("ERRO API", "ERRO AO RECUPERAR MENTORES")
//            }
//        })

        if (currentIndex < profiles.size) {
            if (profiles[currentIndex].area == areaOfInterest && profiles[currentIndex].tempoExp == timeExperience)
                MatchCard(
                    user = currentUser,
                    profile = profiles[currentIndex],
                    onLike = {
                        likedPairs.add(mentorData to profiles[currentIndex])
                        currentIndex++
                    },
                    onDislike = { currentIndex++ },
                    navController = navController
                )
        } else {
            NoMoreProfilesCard()
        }


        // Check for matches
        val matches = findMatches(likedPairs)
        matches.forEach { match ->
            if (currentUser.accountType.capitalize() == "Mentor") {
                Log.i("MATCH", "${match.first} and ${match.second} matched!")

            } else if (currentUser.accountType.capitalize() == "Apprentice") {
                Log.i("MATCH", "${match.second} and ${match.first} matched!")

            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun MatchScreenPreview() {
//    FilteredMatchScreen(
//        navController = NavController(LocalContext.current),
//        User("carlos", "Mentor"),
//        "Back-end",
//        "0-1",
//        createNotification("New Match", "You have a new match!")
//    )
//}