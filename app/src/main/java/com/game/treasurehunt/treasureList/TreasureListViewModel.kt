package com.game.treasurehunt.treasureList

import androidx.lifecycle.*
import com.game.treasurehunt.data.Treasure
import com.game.treasurehunt.data.TreasureRepository
import kotlinx.coroutines.launch

//class TreasureListViewModel(val dataSource: DataSource) : ViewModel() {
//    val treasureLiveData = dataSource.getTreasureList()
//
//    fun insertTreasure(
//        image: String?,
//        name: String?,
//        longitude: String?,
//        latitude: String?,
//        searchTime: String?,
//        like: Boolean?,
//        level: EnumLevel?,
//        description: String?,
//        memo: String?,
//    ) {
//        if (image == null || name == null || longitude == null || latitude == null || searchTime == null || like == null || level == null || description == null || memo == null) {
//            return
//        }
//
//        val newTreasure = Treasure(
//            image,
//            name,
//            longitude,
//            latitude,
//            searchTime,
//            like,
//            level,
//            description,
//            memo,
//        )
//
//        dataSource.addTreasure(newTreasure)
//    }
//}
//
//class TreasureListViewModelFactory : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if (modelClass.isAssignableFrom(TreasureListViewModel::class.java)) {
//            @Suppress("UNCHECKED_CAST")
//            return TreasureListViewModel(
//                dataSource = DataSource.getDataSource()
//            ) as T
//        }
//        throw IllegalArgumentException("Unknown ViewModel Class")
//    }
//}

class TreasureListViewModel(private val repository: TreasureRepository) : ViewModel() {
    val treasureLiveData: LiveData<List<Treasure>> = repository.allTreasure.asLiveData()

    fun insert(treasure: Treasure) = viewModelScope.launch {
        repository.insert(treasure)
    }

    fun update(treasure: Treasure) = viewModelScope.launch {
        repository.insert(treasure)
    }

    fun delete(treasure: Treasure) = viewModelScope.launch {
        repository.delete(treasure)
    }
}

class TreasureListViewModelFactory(private val repository: TreasureRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TreasureListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TreasureListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}