package com.ivanojok.interswitchapp.network

import android.content.Context
import android.net.ConnectivityManager


class Network {
    private fun isNetworkAvailable(context: Context): Boolean {
        val connectivityManager =   context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}