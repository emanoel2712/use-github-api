package br.com.evjdev.githubapi.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.evjdev.githubapi.domain.model.Gists
import br.com.evjdev.githubapi.domain.usecase.GetGistsUseCase
import br.com.evjdev.githubapi.presentation.model.GistsViewObject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getGistsUseCase: GetGistsUseCase) :
    ViewModel() {

    private var _gists = MutableLiveData<List<GistsViewObject>>()
    var gists: LiveData<List<GistsViewObject>> = _gists

    fun getGists() {
        viewModelScope.launch(Dispatchers.IO) {

            getGistsUseCase().onSuccess {
                _gists.postValue(it.map { gists ->
                    GistsViewObject(gists)
                })

            }.onFailure {

            }
        }
    }
}