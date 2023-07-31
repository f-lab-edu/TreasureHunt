package com.game.treasurehunt.data

data class Treasure(
    val image: Int,
    val name: String,
    val searchTime: String,
    val like: Boolean,
    val level: EnumLevel,
    val description: String,
    val memo: String
)