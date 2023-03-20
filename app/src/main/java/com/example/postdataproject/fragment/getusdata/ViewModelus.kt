package com.example.postdataproject.fragment.getusdata

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postdataproject.R
import com.example.postdataproject.model.Data
import com.example.postdataproject.model.TestdataItem

import com.example.postdataproject.model.usdata
import com.example.postdataproject.repository.RetroRepository
import com.example.postdataproject.util.BaseViewModel
import com.example.postdataproject.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@RequiresApi(Build.VERSION_CODES.M)
@HiltViewModel
class ViewModelus @Inject constructor(
    private val repository: RetroRepository,
    application: Application
) : BaseViewModel(application) {


    private val mContext = application

    private val _allUsers = MutableLiveData<NetworkResult<usdata>>()
    val allUsers: LiveData<NetworkResult<usdata>>
        get() = _allUsers




    init {
        getAllUsdata()
    }

//    private fun getAllus() {
//        viewModelScope.launch {
//            if(isConnected()){
//                _allUsers.value = NetworkResult.Loading()
//                val response = repository.showAPIus()
//                _allUsers.value = handleResponse(response)
//            } else {
//                _allUsers.value = NetworkResult.Error(
//                    mContext.getString(R.string.no_Internet)
//                )
//            }
//        }
//    }


    fun getAllUsdata() {
        viewModelScope.launch {
            if(isConnected()){
                _allUsers.value = NetworkResult.Loading()
                val response = repository.getdatafromApius()
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }





}