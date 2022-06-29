package com.ivanojok.interswitchapp.model

import androidx.room.*

@Dao
interface ItemDataDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(vararg item: ItemDataEntity)

    @Query("SELECT * FROM ItemDataEntity WHERE id= :id")
    suspend fun getItemById(id: Long):ItemDataEntity?

    @Query("DELETE FROM ItemDataEntity")
    suspend fun deleteAllItems()




//    @Query("SELECT * FROM ItemDataEntity")
//    fun getItems():LiveData<ItemDataEntity>

    @Delete
    fun deleteItem(item: ItemDataEntity)

    @Update
    fun updateItem(vararg item: ItemDataEntity)


}