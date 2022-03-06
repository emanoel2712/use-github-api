package br.com.evjdev.githubapi.extension

import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackBar(str: String) {
    Snackbar.make(requireView(), str, Snackbar.LENGTH_LONG).show()
}