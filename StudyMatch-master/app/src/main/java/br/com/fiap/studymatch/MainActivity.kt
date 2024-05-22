package br.com.fiap.studymatch

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.studymatch.beans.User
import br.com.fiap.studymatch.screens.AddInfoScreen
import br.com.fiap.studymatch.screens.AdvancedSearchScreen
import br.com.fiap.studymatch.screens.ConnectionsScreenApprentice
import br.com.fiap.studymatch.screens.ConnectionsScreenMentor
import br.com.fiap.studymatch.screens.FilteredMatchScreen
import br.com.fiap.studymatch.screens.InitialScreen
import br.com.fiap.studymatch.screens.LoginScreen
import br.com.fiap.studymatch.screens.MatchScreen
import br.com.fiap.studymatch.screens.SignupScreen
import br.com.fiap.studymatch.ui.theme.StudyMatchTheme


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudyMatchTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "InitialScreen",
                        exitTransition = {
                            slideOutOfContainer(towards = AnimatedContentTransitionScope.SlideDirection.End) + fadeOut(
                                animationSpec = tween(5000)
                            )
                        }
                    ) {
                        composable(route = "InitialScreen"){
                            InitialScreen(navController)
                        }
                        composable(route = "LoginScreen"){
                            LoginScreen(navController)
                        }
                        composable(route = "SignupScreen"){
                            SignupScreen(navController)
                        }
                        composable(route = "AddInfo?nome={nome}&username={username}&email={email}&senha={senha}"){
                            val nome = it.arguments?.getString("nome")
                            val username = it.arguments?.getString("username")
                            val email = it.arguments?.getString("email")
                            val senha = it.arguments?.getString("senha")
                            AddInfoScreen(navController, nome!!, username!!, email!!, senha!!)
                        }
                        composable(route = "MatchScreen?username={username}&accountType={accountType}"){
                            val user = it.arguments?.getString("username")
                            val accountType = it.arguments?.getString("accountType")
                            MatchScreen(navController, User(user!!, accountType!!))
                        }
                        composable(route = "ConnectionsScreenMentor?username={username}"){
                            val username = it.arguments?.getString("username")
                            ConnectionsScreenMentor(navController, username!!)
                        }
                        composable(route = "ConnectionsScreenApprentice?username={username}"){
                            val username = it.arguments?.getString("username")
                            ConnectionsScreenApprentice(navController, username!!)
                        }
                        composable(route = "AdvancedSearchScreen?username={username}&accountType={accountType}"){
                            val user = it.arguments?.getString("username")
                            val accountType = it.arguments?.getString("accountType")
                            AdvancedSearchScreen(navController, User(user!!, accountType!!))
                        }
                        composable(route = "FilteredMatchScreen?username={username}&accountType={accountType}&areaOfInterest={areaOfInterest}&timeExperience={timeExperience}"){
                            val user = it.arguments?.getString("username")
                            val accountType = it.arguments?.getString("accountType")
                            val areaOfInterest = it.arguments?.getString("areaOfInterest")
                            val timeExperience = it.arguments?.getString("timeExperience")
                            FilteredMatchScreen(navController, User(user!!, accountType!!), areaOfInterest!!, timeExperience!!)
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StudyMatchTheme {
        Greeting("Android")
    }
}