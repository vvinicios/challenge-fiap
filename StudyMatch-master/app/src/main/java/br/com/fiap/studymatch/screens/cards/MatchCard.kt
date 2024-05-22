package br.com.fiap.studymatch.screens.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.fiap.studymatch.R
import br.com.fiap.studymatch.beans.Apprentice
import br.com.fiap.studymatch.beans.Mentor
import br.com.fiap.studymatch.beans.User
import br.com.fiap.studymatch.ui.theme.Kanit
import br.com.fiap.studymatch.ui.theme.backgroundGray
import br.com.fiap.studymatch.ui.theme.terciaryBlue
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MatchCard(user : User, profile: Any, onLike: () -> Unit, onDislike: () -> Unit, navController: NavController) {

    when (profile) {
        is Mentor -> {
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
                        contentDescription = "Simbolo de grupo",
                        modifier = Modifier.clickable { navController.navigate("ConnectionsScreenApprentice?usernameMentor=${profile.username}") }.padding(5.dp)
                    )
                    Image(
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = "Simbolo de filtro",
                        modifier = Modifier.clickable { navController.navigate("AdvancedSearchScreen") }
                    )
                }
                Column(
                    modifier = Modifier.width(300.dp)
                ) {
                    Card(
                        colors = CardDefaults.cardColors(terciaryBlue),
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(profile.idImage)
                                .crossfade(true)
                                .build(),
                            placeholder = painterResource(R.drawable.mentor_studymatch),
                            contentDescription = null,
                            modifier = Modifier.width(300.dp).height(400.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(text = "Mentor", color = Color.White, fontFamily = Kanit)
                            Text(text = profile.nome, color = Color.White, fontFamily = Kanit)
                            Text(text = profile.area, color = Color.White, fontFamily = Kanit)
                            Text(
                                text = "${profile.tempoExp} anos de experiencia",
                                color = Color.White,
                                fontFamily = Kanit
                            )
                            Text(
                                text = profile.habilitys.toString().replace("[", "")
                                    .replace("]", ""),
                                color = Color.White,
                                fontFamily = Kanit
                            )
                            Text(text = profile.email, color = Color.White, fontFamily = Kanit)

                        }
                        Row(
                            modifier = Modifier.width(300.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            IconButton(onClick = onDislike) {
                                Image(
                                    painter = painterResource(id = R.drawable.close),
                                    contentDescription = "Dislike",
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(66.dp))
                            IconButton(onClick = onLike) {
                                Image(
                                    painter = painterResource(id = R.drawable.check),
                                    contentDescription = "Like",
                                    modifier = Modifier.size(40.dp)
                                )
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }

                }
            }
        }

        is Apprentice -> {
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
                        contentDescription = "Simbolo de grupo",
                        modifier = Modifier.clickable { navController.navigate("ConnectionsScreenApprentice?username=${profile.username}") }
                    )
                    Image(
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = "Simbolo de filtro",
                        modifier = Modifier.clickable { navController.navigate("AdvancedSearchScreen?username=${user.username}&accountType=${user.accountType}") }
                    )
                }
                Column(
                    modifier = Modifier.width(300.dp)
                ) {
                    Card(
                        colors = CardDefaults.cardColors(terciaryBlue),
                    ) {
                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(profile.idImage)
                                .crossfade(true)
                                .build(),
                            //placeholder = painterResource(R.drawable.mentor_studymatch),
                            contentDescription = null,
                            modifier = Modifier.width(300.dp).height(400.dp),
                            contentScale = ContentScale.Crop
                        )

                        Column(
                            modifier = Modifier.padding(20.dp)
                        ) {
                            Text(text = "Aprendiz", color = Color.White, fontFamily = Kanit)
                            Text(text = profile.nome, color = Color.White, fontFamily = Kanit)
                            Text(text = profile.area, color = Color.White, fontFamily = Kanit)
                            Text(
                                text = "${profile.tempoExp} anos de experiencia",
                                color = Color.White,
                                fontFamily = Kanit
                            )
                            Text(
                                text = profile.habilitys.toString().replace("[", "")
                                    .replace("]", ""),
                                color = Color.White,
                                fontFamily = Kanit
                            )
                            Text(text = profile.email, color = Color.White, fontFamily = Kanit)

                        }
                        Row(
                            modifier = Modifier.width(300.dp),
                            horizontalArrangement = Arrangement.Center
                        ) {
                            IconButton(onClick = onDislike) {
                                Image(
                                    painter = painterResource(id = R.drawable.close),
                                    contentDescription = "Dislike",
                                    modifier = Modifier.size(40.dp)
                                )
                            }
                            Spacer(modifier = Modifier.width(66.dp))
                            IconButton(onClick = onLike) {
                                Image(
                                    painter = painterResource(id = R.drawable.check),
                                    contentDescription = "Like",
                                    modifier = Modifier.size(40.dp)
                                )
                            }

                        }
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
private fun MatchCardPreview() {
    val listH = listOf("Python", "java", "aws")
    val mentor = Mentor(
        R.drawable.mentor_studymatch.toString(),
        "Carlos",
        "Carlos",
        "Back-end",
        "+8",
        listH.toString().replace("[", "").replace("]", ""),
        "carlosprestes@outlook.com",
        "2312313"
    )
    MatchCard(User("Angelo", "mentor"),mentor, {}, {}, NavController(LocalContext.current))
}