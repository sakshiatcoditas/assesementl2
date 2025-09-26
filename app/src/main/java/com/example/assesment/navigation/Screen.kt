package com.example.assesment.navigation

 sealed class Screen (val route: String){

object LoginScreen:Screen("login")
 object RegisterScreen:Screen("register")
  object HomeScreen: Screen("home")


}