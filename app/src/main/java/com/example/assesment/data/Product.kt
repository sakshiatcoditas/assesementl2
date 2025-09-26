package com.example.assesment.data

data class Product(
    val productId: String = "",
    val name: String = "",
    val description: String = "",
    val imageUrl: String = "",
    val startPrice: Double = 0.0,
    val currentBid: Double = 0.0,
    val createdBy: String = "",
    val auctionEndTime: Long = 0L,
    val createdAt: Long = System.currentTimeMillis()
)