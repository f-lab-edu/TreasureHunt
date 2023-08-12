package com.game.treasurehunt.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.game.treasurehunt.data.Treasure

@Database(
    version = 1,
    entities = [Treasure::class],
)
abstract class TreasureDatabase : RoomDatabase() {
    abstract fun treasureDao(): TreasureDao

    companion object {
        private var instance: TreasureDatabase? = null

        @Synchronized
        fun getInstance(context: Context): TreasureDatabase? {
            if (instance == null) {
                synchronized(TreasureDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        TreasureDatabase::class.java,
                        "treasure-database"
                    ).build()
                }
            }
            return instance
        }
    }
}