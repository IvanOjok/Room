package com.ivanojok.interswitchapp.network

import com.ivanojok.interswitchapp.model.APIResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ItemDataInterface {

    @GET("{id}")
    fun getItemData(@Path("id") id:Long, @Query("getRelatedData") getRelatedData:Boolean): Call<APIResponse>

    companion object{
        val url = "https://iswapigateway-develop.azurewebsites.net/qt-api/Item/fee/"
    }
}