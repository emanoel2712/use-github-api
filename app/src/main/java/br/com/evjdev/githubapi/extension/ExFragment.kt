package br.com.evjdev.githubapi.extension

import androidx.fragment.app.Fragment
import br.com.evjdev.githubapi.presentation.view.activity.MainActivity
import com.google.android.material.snackbar.Snackbar

fun Fragment.showSnackBar(str: String) {
    Snackbar.make(requireView(), str, Snackbar.LENGTH_LONG).show()
}

fun Fragment.showToolbar(title: String) {
    (requireActivity() as MainActivity).supportActionBar?.title = title
    (requireActivity() as MainActivity).supportActionBar?.show()
}

fun Fragment.hideToolbar() {
    (requireActivity() as MainActivity).supportActionBar?.hide()
}