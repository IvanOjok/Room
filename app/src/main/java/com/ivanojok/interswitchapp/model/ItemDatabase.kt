package com.ivanojok.interswitchapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(entities = arrayOf(ItemDataEntity::class), version = 1)
@TypeConverters(Converters::class)
abstract class ItemDatabase: RoomDatabase() {
    abstract fun ItemDataDao(): ItemDataDAO

    companion object {
        var Instance: ItemDatabase?= null
        fun getInstance(context: Context): ItemDatabase {
            if (Instance == null){
                Instance = Room.databaseBuilder(context, ItemDatabase::class.java, "roomDB").allowMainThreadQueries().build()
            }
            return Instance as ItemDatabase
        }
    }
}