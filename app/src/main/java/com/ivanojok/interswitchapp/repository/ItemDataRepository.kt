package com.ivanojok.interswitchapp.repository

import androidx.lifecycle.LiveData
import com.ivanojok.interswitchapp.model.*
import com.ivanojok.interswitchapp.network.ItemDataAPI


interface GetItemDataDao{
    suspend fun insertItem(item: ItemDataEntity){
        val itemDB = ItemDatabase.Instance
        itemDB!!.ItemDataDao().insertItem(item)
    }

    suspend fun getItemById(id:Long): ItemDataEntity?{
        val itemDB = ItemDatabase.Instance
       return itemDB!!.ItemDataDao().getItemById(id)
    }

    suspend fun deleteAllItems(){
        val itemDB = ItemDatabase.Instance
        itemDB!!.ItemDataDao().deleteAllItems()
    }
}

class ItemDataRepository(private val dao: GetItemDataDao) {
    suspend fun insert(
        x:ItemDataEntity
    ) = dao.insertItem(x)

    //suspend fun delete(item: Cart, phone: String) = dao.delete(item, phone)

    suspend fun getItemById(id: Long) = dao.getItemById(id)

    suspend fun deleteAllItems() = dao.deleteAllItems()


    fun getDataFromAPI(id: Long) = ItemDataAPI().RetrofitClient(id)
}