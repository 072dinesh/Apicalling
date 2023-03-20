package com.example.postdataproject.fragment.cureentprice

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope


import com.example.postdataproject.R
import com.example.postdataproject.model.Randoms

import com.example.postdataproject.model.current

import com.example.postdataproject.repository.RetroRepository
import com.example.postdataproject.util.BaseViewModel
import com.example.postdataproject.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@HiltViewModel
class ViewModelSecond @Inject constructor(
    private val repository: RetroRepository,
    application: Application
) : BaseViewModel(application) {

   // val myResponseView: MutableLiveData<NetworkResult<current>> = MutableLiveData()
    private val _allUsers = MutableLiveData<NetworkResult<Randoms>>()
    val allUsers: LiveData<NetworkResult<Randoms>>
        get() = _allUsers
//
    var mContext = application


    fun getPost2() {
        viewModelScope.launch {
            if(isConnected()){
                _allUsers.value = NetworkResult.Loading()
                val response = repository.getDataFromAPIso()
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }



}