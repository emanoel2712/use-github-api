package br.com.evjdev.githubapi.network.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build
import javax.inject.Inject

class NetworkConnectionImpl @Inject constructor(private val application: Application) :
    NetworkConnection {

    private fun hasNetwork(cm: ConnectivityManager, network: Network?): Boolean {
        cm.getNetworkCapabilities(network)?.also {
            when {
                it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> return true
                it.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> return true
                it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> return true
            }
        }
        return false
    }

    override fun hasInternet(): Boolean {
        var result = false
        (application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                result = hasNetwork(this, this.activeNetwork)
            } else {
                val networkInfoStatus = this.allNetworks
                for (tempNetworkInfo in networkInfoStatus) {
                    if (hasNetwork(this, tempNetworkInfo)) result = true
                }
            }
        }
        return result
    }
}