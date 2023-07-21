package com.game.treasurehunt.data

import android.content.res.Resources

fun treasureList(resources: Resources): List<Treasure> {
    return listOf(
        Treasure(0, "서울 숭례문", "2023-07-04 13:22:21", true),
        Treasure(0, "서울 원각사지 십층 석탑", "2023-07-05 13:22:21", false),
        Treasure(0, "여주 고달사지 승탑", "2023-07-07 13:22:21", true),
        Treasure(0, "국보 2", "2023-05-06 13:22:21", false),
        Treasure(0, "국보 3", "2023-06-06 13:22:21", false),
        Treasure(0, "국보 4", "2022-07-06 12:22:21", false),
        Treasure(0, "국보 5", "2021-07-06 11:22:21", false),
        Treasure(0, "국보 6", "2024-07-06 13:22:21", false),
        Treasure(0, "국보 7", "2025-07-06 13:22:21", false),
        Treasure(0, "국보 8", "2026-07-06 13:22:21", false)
    )
}