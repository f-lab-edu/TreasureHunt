package com.game.treasurehunt.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Treasure(
    @PrimaryKey val name: String,
    val type: String,
    val longitude: String,
    val latitude: String,
    val searchTime: String,
    val like: Boolean,
    val level: EnumLevel,
    val image: String,
    val description: String,
    val memo: String
)