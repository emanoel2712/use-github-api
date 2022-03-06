package br.com.evjdev.githubapi.presentation.model

import androidx.annotation.StringRes

sealed class ViewState(@StringRes id: Int? = null) {
    object Success : ViewState()
    data class Error(@StringRes var id: Int) : ViewState(id)
    object Loading : ViewState()
}
