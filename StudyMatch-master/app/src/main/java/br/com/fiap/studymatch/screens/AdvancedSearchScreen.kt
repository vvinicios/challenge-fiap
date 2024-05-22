package br.com.fiap.studymatch.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.studymatch.R
import br.com.fiap.studymatch.beans.User
import br.com.fiap.studymatch.screens.forms.AreaOfInterestForm
import br.com.fiap.studymatch.screens.forms.TimeExperienceForm
import br.com.fiap.studymatch.ui.theme.Kanit
import br.com.fiap.studymatch.ui.theme.backgroundGray
import br.com.fiap.studymatch.ui.theme.primaryBlue

@Composable
fun AdvancedSearchScreen(navController: NavController, user: User) {

    var areaOfInterest by remember {
        mutableStateOf("")
    }
    var timeExperience by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGray)
            .verticalScroll(ScrollState(0)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Row (
        ){
            Text(
                text = "Pesquisa Avançada",
                color = Color.White,
                fontFamily = Kanit,
                fontSize = 32.sp,
                modifier = Modifier.width(200.dp),
                textAlign = TextAlign.Center
            )
            Image(painter = painterResource(id = R.drawable.search), contentDescription = "Lupa de pesquisa", modifier = Modifier.size(100.dp))
        }
        Spacer(modifier = Modifier.height(30.dp))
        areaOfInterest = AreaOfInterestForm()
        Spacer(modifier = Modifier.height(30.dp))
        timeExperience = TimeExperienceForm()
        Spacer(modifier = Modifier.height(30.dp))


        Button(
            onClick = { navController.navigate("FilteredMatchScreen?username=${user.username}&accountType=${user.accountType}&areaOfInterest=$areaOfInterest&timeExperience=$timeExperience") },
            colors = ButtonDefaults.buttonColors(primaryBlue),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "Pesquisar",  fontFamily = Kanit)
        }


    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun AdvancedSearchScreenPreview() {
    val user = "Angelo";
    AdvancedSearchScreen(
        navController = NavController(LocalContext.current),
        user = User(user!!, "Mentor")
    )
}