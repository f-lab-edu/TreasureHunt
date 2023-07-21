package com.game.treasurehunt.treasureList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.game.treasurehunt.data.DataSource
import com.game.treasurehunt.data.Treasure

class TreasureListViewModel(val dataSource: DataSource) : ViewModel() {
    val treasureLiveData = dataSource.getTreasureList()

    fun insertTreasure(image: Int?, name: String?, searchTime: String?, like: Boolean?) {
        if(image == null || name == null || searchTime == null || like == null) {
            return
        }

        val newTreasure = Treasure(
            image,
            name,
            searchTime,
            like
        )

        dataSource.addTreasure(newTreasure)
    }
}

class TreasureListViewModelFactory(private val context: TreasureListFragment) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TreasureListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TreasureListViewModel(
                dataSource = DataSource.getDataSource(context.resources)
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
