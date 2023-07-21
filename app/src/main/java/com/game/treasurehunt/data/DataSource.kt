package com.game.treasurehunt.data

import android.content.res.Resources
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DataSource(resources: Resources) {
    private val initialTreasureList = treasureList(resources)
    private val treasureLiveData = MutableLiveData(initialTreasureList)

    fun addTreasure(treasure: Treasure) {
        val currentList = treasureLiveData.value
        if (currentList == null) {
            treasureLiveData.postValue(listOf(treasure))
        } else {
            val updatedList = currentList.toMutableList()
            updatedList.add(0, treasure)
            treasureLiveData.postValue(updatedList)
        }
    }

    fun removeTreasure(treasure: Treasure) {
        val currentList = treasureLiveData.value
        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(treasure)
            treasureLiveData.postValue(updatedList)
        }
    }

    fun getTreasureList(): LiveData<List<Treasure>> {
        return treasureLiveData
    }

    companion object {
        private var INSTANCE: DataSource? = null

        fun getDataSource(resources: Resources): DataSource {
            return synchronized(DataSource::class) {
                val newInstance = INSTANCE ?: DataSource(resources)
                INSTANCE = newInstance
                newInstance
            }
        }
    }
}