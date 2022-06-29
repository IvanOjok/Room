package com.ivanojok.interswitchapp.model

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class Converters {
    @TypeConverter
    fun fromPayConfigurationListToString(list: List<PayConfiguration>): String {
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun fromStringToPayConfigurationList(s: String): List<PayConfiguration> {
        return Json.decodeFromString(s)
    }

    @TypeConverter
    fun fromFeeGroupsListToString(list: List<FeeGroups>): String {
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun fromStringToFeeGroupsList(s: String): List<FeeGroups> {
        return Json.decodeFromString(s)
    }

    @TypeConverter
    fun fromItemFeeMapSettingsListToString(list: List<ItemFeeMapSettings>): String {
        return Json.encodeToString(list)
    }

    @TypeConverter
    fun fromStringToItemFeeMapSettingsList(s: String): List<ItemFeeMapSettings> {
        return Json.decodeFromString(s)
    }

}