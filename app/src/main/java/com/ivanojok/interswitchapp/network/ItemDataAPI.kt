package com.ivanojok.interswitchapp.network

import android.util.Log
import com.ivanojok.interswitchapp.model.APIResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ItemDataAPI {
    val itemInterface = ItemDataInterface
    var itemData:APIResponse ?= null
    fun RetrofitClient(id:Long): APIResponse{
        val retrofit = Retrofit.Builder().baseUrl(itemInterface.url).addConverterFactory(GsonConverterFactory.create()).build()
        val instance = retrofit.create(ItemDataInterface::class.java)
        instance.getItemData(id,true).enqueue(object : Callback<APIResponse>{
            override fun onResponse(
                call: Call<APIResponse>,
                response: Response<APIResponse>
            ) {
                itemData = response.body()!!
            }

            override fun onFailure(call: Call<APIResponse>, t: Throwable) {
                Log.d("Error occured", t.toString())
            }

        })

        return itemData!!

    }

}
