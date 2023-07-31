package com.game.treasurehunt.treasureList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.game.treasurehunt.data.DataSource
import com.game.treasurehunt.data.EnumLevel
import com.game.treasurehunt.data.Treasure

class TreasureListViewModel(val dataSource: DataSource) : ViewModel() {
    val treasureLiveData = dataSource.getTreasureList()

    fun insertTreasure(
        image: Int?,
        name: String?,
        searchTime: String?,
        like: Boolean?,
        level: EnumLevel?,
        description: String?,
        memo: String?,
    ) {
        if (image == null || name == null || searchTime == null || like == null || level == null || description == null || memo == null) {
            return
        }

        val newTreasure = Treasure(
            image,
            name,
            searchTime,
            like,
            level,
            description,
            memo,
        )

        dataSource.addTreasure(newTreasure)
    }
}

class TreasureListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TreasureListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TreasureListViewModel(
                dataSource = DataSource.getDataSource()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
