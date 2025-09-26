package com.example.assesment.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import com.example.assesment.navigation.Screen

@Composable
fun RegisterScreen(navHostController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        //name field
        OutlinedTextField(
            modifier =
                Modifier.fillMaxSize(),
            value = name,
            onValueChange = { name = it },

            )
        Spacer(modifier = Modifier.fillMaxSize())


        //email field
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = email,
            onValueChange = { email = it }
        )
        Spacer(modifier = Modifier.fillMaxSize())

        //Password Field

        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = password,
            onValueChange = { password = it }
        )

        Spacer(modifier = Modifier.fillMaxSize())

        //Confirm Password Field
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = confirmPassword,
            onValueChange = { password = it }
        )

        Spacer(modifier = Modifier.fillMaxSize())


        //Register Button

        Button(modifier = Modifier.fillMaxSize(), onClick = {
            navHostController.navigate(Screen.LoginScreen.route)
        }) {
            Text(text = "Register")
        }

        //Already have an account text
        Text(text = "Already have an account text")

    }
}

