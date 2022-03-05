package br.com.evjdev.githubapi.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.evjdev.githubapi.domain.model.Gists
import br.com.evjdev.githubapi.domain.usecase.GetGistsUseCase
import br.com.evjdev.githubapi.presentation.model.GistsViewObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getGistsUseCase: GetGistsUseCase) :
    ViewModel() {

    private var _gists = MutableLiveData<GistsViewObject>()
    var gists: LiveData<GistsViewObject> = _gists

    fun getGists() {
        viewModelScope.launch(Dispatchers.IO) {

            getGistsUseCase().onSuccess {
                _gists.postValue(GistsViewObject(it))

            }.onFailure {

            }
        }
    }
}