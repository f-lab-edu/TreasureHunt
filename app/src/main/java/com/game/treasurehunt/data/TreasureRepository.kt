package com.game.treasurehunt.data

import androidx.annotation.WorkerThread
import com.game.treasurehunt.data.local.TreasureDao
import kotlinx.coroutines.flow.Flow

class TreasureRepository(private val treasureDao: TreasureDao) {
    val allTreasure: Flow<List<Treasure>> = treasureDao.getAll()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(treasure: Treasure) {
        treasureDao.insert(treasure)
    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun update(treasure: Treasure) {
        treasureDao.update(treasure)
    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun delete(treasure: Treasure) {
        treasureDao.delete(treasure)
    }
}