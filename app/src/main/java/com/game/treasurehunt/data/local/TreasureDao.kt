package com.game.treasurehunt.data.local

import androidx.room.*
import com.game.treasurehunt.data.Treasure
import kotlinx.coroutines.flow.Flow

@Dao
interface TreasureDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(treasure: Treasure)

    @Update
    fun update(treasure: Treasure)

    @Delete
    fun delete(treasure: Treasure)

    @Query("SELECT * FROM Treasure")
    fun getAll(): Flow<List<Treasure>>
}