package com.example.postdataproject.fragment.cocktaildatabase

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postdataproject.R
import com.example.postdataproject.model.Cocktaildata
import com.example.postdataproject.model.Randoms
import com.example.postdataproject.repository.RetroRepository
import com.example.postdataproject.util.BaseViewModel
import com.example.postdataproject.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModelCocktail @Inject constructor(
    private val repository: RetroRepository,
    application: Application
) : BaseViewModel(application) {

    // val myResponseView: MutableLiveData<NetworkResult<current>> = MutableLiveData()
    private val _allUsers = MutableLiveData<NetworkResult<Cocktaildata>>()
    val allUsers: LiveData<NetworkResult<Cocktaildata>>
        get() = _allUsers
    //
    var mContext = application


    init {

        showdatacocktail()
    }

    fun getPostcocktail(query:String) {
        viewModelScope.launch {
            if(isConnected()){
                _allUsers.value = NetworkResult.Loading()
                val response = repository.getdatafromApiCocktail(query)
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }
    fun showdatacocktail() {
        viewModelScope.launch {
            if(isConnected()){
                _allUsers.value = NetworkResult.Loading()
                val response = repository.showAPIcocktails()
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }


}