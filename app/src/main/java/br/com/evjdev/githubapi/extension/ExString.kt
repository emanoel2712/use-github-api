package br.com.evjdev.githubapi.extension
import java.text.SimpleDateFormat
import java.util.*

fun String.toDateStr(): String {
    val dateFIn = SimpleDateFormat("yyyy-mm-dd", Locale.getDefault())
    val dateFOut = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    dateFIn.parse(this)?.let {
        return dateFOut.format(it)
    }

    return ""
}