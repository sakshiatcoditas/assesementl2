package com.example.assesment.data

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    val profilePic: String = "",
    val createdAt: Long = System.currentTimeMillis()
)