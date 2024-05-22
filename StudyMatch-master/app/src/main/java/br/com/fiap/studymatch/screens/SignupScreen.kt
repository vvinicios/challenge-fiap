package br.com.fiap.studymatch.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.studymatch.R
import br.com.fiap.studymatch.ui.theme.Kanit
import br.com.fiap.studymatch.ui.theme.backgroundGray
import br.com.fiap.studymatch.ui.theme.primaryBlue
import br.com.fiap.studymatch.ui.theme.secundaryBlue

@Composable
fun SignupScreen(navController: NavController) {

    var nameState by remember {
        mutableStateOf("")
    }
    var usernameState by remember {
        mutableStateOf("")
    }
    var emailState by remember {
        mutableStateOf("")
    }
    var passwordState by remember {
        mutableStateOf("")
    }
    var confirmPasswordState by remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundGray),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "Cadastro",
            color = Color.White,
            fontFamily = Kanit,
            fontSize = 32.sp
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = nameState,
            onValueChange = { nameState = it },
            modifier = Modifier.padding(10.dp),
            placeholder = { Text(text = "Digite seu nome", color = Color.White) },
            label = { Text(text = "Nome", color = Color.White) },
            shape = RoundedCornerShape(15.dp),
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.colors(focusedContainerColor = secundaryBlue, unfocusedContainerColor = primaryBlue)

        )
        TextField(
            value = usernameState,
            onValueChange = { usernameState = it },
            modifier = Modifier.padding(10.dp),
            placeholder = { Text(text = "Digite seu Usuario", color = Color.White) },
            label = { Text(text = "Usuario", color = Color.White) },
            shape = RoundedCornerShape(15.dp),
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.colors(focusedContainerColor = secundaryBlue, unfocusedContainerColor = primaryBlue)

        )
        TextField(
            value = emailState,
            onValueChange = { emailState = it },
            modifier = Modifier.padding(10.dp),
            placeholder = { Text(text = "Digite seu email", color = Color.White) },
            label = { Text(text = "Email", color = Color.White) },
            shape = RoundedCornerShape(15.dp),
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.colors(focusedContainerColor = secundaryBlue, unfocusedContainerColor = primaryBlue)

        )
        TextField(
            value = passwordState,
            onValueChange = { passwordState = it },
            modifier = Modifier.padding(10.dp),
            placeholder = { Text(text = "Digite sua senha", color = Color.White) },
            label = { Text(text = "Senha", color = Color.White) },
            shape = RoundedCornerShape(15.dp),
            textStyle = TextStyle(color = Color.White),
            colors = TextFieldDefaults.colors(focusedContainerColor = secundaryBlue, unfocusedContainerColor = primaryBlue)

        )
        var passwordError by remember {
            mutableStateOf(false)
        }
        if (passwordError){
            Text(text = "Senhas não são iguais", color = Color.White, fontSize = 12.sp)
        }
        TextField(
            value = confirmPasswordState,
            onValueChange = { confirmPasswordState = it },
            modifier = Modifier.padding(10.dp),
            placeholder = { Text(text = "Confirme sua senha", color = if(!passwordError) Color.White else Color.Red) },
            label = { Text(text = "Confirmação", color = if(!passwordError) Color.White else Color.Red) },
            shape = RoundedCornerShape(15.dp),
            textStyle = TextStyle(color = Color.White),
            isError = passwordError,
            colors = TextFieldDefaults.colors(focusedContainerColor = secundaryBlue, unfocusedContainerColor = primaryBlue, errorContainerColor = secundaryBlue, errorTextColor = Color.Red)

        )

        Button(
            onClick = { if (passwordState == confirmPasswordState) navController.navigate("AddInfo?nome=$nameState&username=$usernameState&email=$emailState&senha=$passwordState") else passwordError = true },
            colors = ButtonDefaults.buttonColors(primaryBlue),
            shape = RoundedCornerShape(15.dp),
            modifier = Modifier
                .padding(20.dp)
                .height(45.dp)
                .width(150.dp)
        ) {
            Text(text = "Entrar")
        }
    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun SignupScreenPreview() {
    SignupScreen(navController = NavController(LocalContext.current))
}