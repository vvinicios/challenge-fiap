package br.com.fiap.studymatch.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import br.com.fiap.studymatch.ui.theme.Kanit
import br.com.fiap.studymatch.ui.theme.backgroundGray
import br.com.fiap.studymatch.ui.theme.primaryBlue

@Composable
fun InitialScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.cap),
            contentDescription = "chapeu",
            modifier = Modifier
                .padding(top = 200.dp)
                .size(72.dp)
        )
        Text(
            text = "StudyMatch",
            color = Color.White,
            fontSize = 36.sp,
            fontFamily = Kanit
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = {
            navController.navigate("LoginScreen")
        }, colors = ButtonDefaults.buttonColors(primaryBlue)) {

            Text(text = "Clique para entrar")
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun InitialScreenPreview() {
    InitialScreen(
        navController = NavController(LocalContext.current),
  )
}