package br.com.evjdev.githubapi.presentation.model

import androidx.annotation.StringRes

sealed class ViewState() {
    object Success : ViewState()
    data class Error(@StringRes var id: Int) : ViewState()
    object Loading : ViewState()
}
