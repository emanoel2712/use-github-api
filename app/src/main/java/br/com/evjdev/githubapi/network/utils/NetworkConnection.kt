package br.com.evjdev.githubapi.network.utils

import android.net.ConnectivityManager

interface NetworkConnection {
    fun hasInternet(): Boolean
}