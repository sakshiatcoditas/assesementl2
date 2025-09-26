package com.example.assesment.screens


import android.view.RoundedCorner
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable

fun LoginScreen(navController: NavHostController) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf(" ") }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        //email text
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = "email",
            onValueChange = {email}

        )

        Spacer(modifier = Modifier.fillMaxSize())

        //pasword text
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value="password",
            onValueChange = {password}
        )

        Spacer(modifier = Modifier.fillMaxSize())


        //login button
        Button(modifier = Modifier.fillMaxSize(), onClick = {
            navController.navigate("home")

        }) {
            Text(text = "Login")
        }

       Spacer(modifier=Modifier.fillMaxSize())


        //sigin with google button
        Button(modifier = Modifier.fillMaxSize(), onClick = {
            navController.navigate("home")
        }) {
            Text(text = "Sigin with Google Account")
        }

        Spacer(modifier = Modifier.fillMaxSize())

        //Dont have an account? Register

       Text(text = "Dont have an account? Register"
       )

    }




}
