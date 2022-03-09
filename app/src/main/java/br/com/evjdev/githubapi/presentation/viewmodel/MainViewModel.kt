package br.com.evjdev.githubapi.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.evjdev.githubapi.R
import br.com.evjdev.githubapi.data.exception.RepositoryException
import br.com.evjdev.githubapi.domain.model.Gists
import br.com.evjdev.githubapi.domain.usecase.GetGistsUseCase
import br.com.evjdev.githubapi.presentation.model.GistsViewObject
import br.com.evjdev.githubapi.presentation.model.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getGistsUseCase: GetGistsUseCase
) : ViewModel() {

    private var _gists = MutableLiveData<List<GistsViewObject>>()
    var gists: LiveData<List<GistsViewObject>> = _gists

    private var _viewState = MutableLiveData<ViewState>()
    var viewState: LiveData<ViewState> = _viewState

    private var _gistsFiltered = MutableLiveData<List<GistsViewObject>>()
    val gistsFiltered: LiveData<List<GistsViewObject>> = _gistsFiltered

    fun getGists() {
        _gists.postValue(emptyList())
        _viewState.postValue(ViewState.Loading)

        viewModelScope.launch(Dispatchers.IO) {
            getGistsUseCase().onSuccess {
                _gists.postValue(it.map { gists ->
                    GistsViewObject(gists)
                })

                _viewState.postValue(ViewState.Success)
            }.onFailure {
                when (it) {
                    is RepositoryException.NetworkException -> {
                        _viewState.postValue(ViewState.Error(R.string.no_internet_connection))
                    }
                    is RepositoryException.HttpException -> {
                        _viewState.postValue(ViewState.Error(R.string.error_api))
                    }
                }
            }
        }
    }

    fun filterByName(letter: String) {
        val result = _gists.value?.filter { gistsViewObject ->
            gistsViewObject.owner?.login?.contains(letter, true) == true
        }

        _gistsFiltered.postValue(result ?: emptyList())
    }
}