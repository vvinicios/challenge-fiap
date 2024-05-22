package br.com.fiap.studymatch.screens
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import br.com.fiap.studymatch.beans.Apprentice
import br.com.fiap.studymatch.beans.Mentor
import br.com.fiap.studymatch.beans.User
import br.com.fiap.studymatch.MyFirebaseMessagingService
import br.com.fiap.studymatch.functions.findMatches
import br.com.fiap.studymatch.retrofit.RetrofitInit
import br.com.fiap.studymatch.screens.cards.MatchCard
import br.com.fiap.studymatch.screens.cards.NoMoreProfilesCard
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Composable
fun MatchScreen(navController: NavController, currentUser: User) {

    var currentIndex by remember { mutableStateOf(0) }
    val likedPairs by remember { mutableStateOf(mutableListOf<Pair<Mentor, Apprentice>>()) }

    var apprenticeData by remember {
        mutableStateOf(Apprentice())
    }


    var mentorData by remember {
        mutableStateOf(Mentor())
    }


    if (currentUser.accountType == "Apprentice") {
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
    }

    if (currentUser.accountType == "Aprendiz") {

        var profiles by remember {
            mutableStateOf(listOf<Mentor>())
        }

        val callListarMentores = RetrofitInit().getAPIService().getMentors()

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
                currentUser,
                profile = profiles[currentIndex],
                onLike = {
                    likedPairs.add(profiles[currentIndex] to apprenticeData)
                    currentIndex++
                },
                onDislike = { currentIndex++ },
                navController
            )
        } else {
            NoMoreProfilesCard()
        }
    }

    if (currentUser.accountType == "Mentor") {
        var profiles by remember {
            mutableStateOf(listOf<Apprentice>())
        }


        val call = RetrofitInit().getAPIService().getApprentice()
        call.enqueue(object : Callback<List<Apprentice>>{
            override fun onResponse(call: Call<List<Apprentice>>, response: Response<List<Apprentice>>) {
                profiles = response.body()!!
            }

            override fun onFailure(call: Call<List<Apprentice>>, t: Throwable) {
                Log.i("ERRO API", "ERRO AO RECUPERAR MENTORES")
            }
        })

        if (currentIndex < profiles.size) {
            MatchCard(
                currentUser,
                profile = profiles[currentIndex],
                onLike = {
                    likedPairs.add(mentorData to profiles[currentIndex])
                    currentIndex++
                },
                onDislike = { currentIndex++ },
                navController
            )
        } else {
            NoMoreProfilesCard()
        }

        // Check for matches
        val matches = findMatches(likedPairs)
        matches.forEach { match ->
            if (currentUser.accountType.capitalize() == "Mentor") {
                Log.i("MATCH","${match.first} and ${match.second} matched!")
            } else if (currentUser.accountType.capitalize() == "Apprentice") {
                Log.i("MATCH","${match.second} and ${match.first} matched!")
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//private fun MatchScreenPreview() {
//    MatchScreen(navController = NavController(LocalContext.current), User("carlos", "Mentor"))
//}