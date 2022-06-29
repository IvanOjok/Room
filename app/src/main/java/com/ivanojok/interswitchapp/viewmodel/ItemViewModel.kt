package com.ivanojok.interswitchapp.viewmodel

import androidx.lifecycle.ViewModel
import com.ivanojok.interswitchapp.model.FeeGroups
import com.ivanojok.interswitchapp.model.ItemDataEntity
import com.ivanojok.interswitchapp.model.ItemFeeMapSettings
import com.ivanojok.interswitchapp.model.PayConfiguration
import com.ivanojok.interswitchapp.repository.ItemDataRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class  ItemViewModel(private val repository: ItemDataRepository) : ViewModel() {

    // In coroutines thread insert item in insert function.
    @OptIn(DelicateCoroutinesApi::class)
    fun insert(x: ItemDataEntity) = GlobalScope.launch {
        repository.insert(x)
    }

    // In coroutines thread delete items in delete function.
    @OptIn(DelicateCoroutinesApi::class)
    fun delete() = GlobalScope.launch {
        repository.deleteAllItems()
    }

    //Select item based on id
    suspend fun getItemDetails(id:Long) = repository.getItemById(id)

    suspend fun getAPIData(id: Long) = repository.getDataFromAPI(id)

}