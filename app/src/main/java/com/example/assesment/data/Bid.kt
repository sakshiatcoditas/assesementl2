package com.example.assesment.data

data class Bid(
    val bidId: String = "",
    val productId: String = "",
    val userId: String = "",
    val bidAmount: Double = 0.0,
    val timestamp: Long = System.currentTimeMillis()
)