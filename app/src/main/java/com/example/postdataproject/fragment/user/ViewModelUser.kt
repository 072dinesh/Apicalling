package com.example.postdataproject.fragment.user

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postdataproject.R
import com.example.postdataproject.model.Data
import com.example.postdataproject.model.Result

import com.example.postdataproject.model.random

import com.example.postdataproject.repository.RetroRepository
import com.example.postdataproject.util.BaseViewModel
import com.example.postdataproject.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject




@HiltViewModel
class ViewModelUser @Inject constructor(
    private val repository: RetroRepository,
    application: Application
) : BaseViewModel(application) {

   // val myResponseViewuser: MutableLiveData<NetworkResult<random>> = MutableLiveData()
    private val _allUsers = MutableLiveData<NetworkResult<random>>()
    val allUsers: LiveData<NetworkResult<random>>
        get() = _allUsers
    //
    var mContext = application




//    fun getPostuser() {
//
//
//        viewModelScope.launch {
//            myResponseViewuser.value = NetworkResult.Loading()
//
//            if (isConnected()) {
//
//
//                val response: Response<random> = repository.getDataFromAPIuser()
//                myResponseViewuser.value = handleResponse(response)
//
//
//            } else {
//                myResponseViewuser.value = NetworkResult.Error(
//                    mContext.getString(R.string.no_Internet)
//                )
//            }
//
//
//        }
//    }
    fun getPostuser() {
        viewModelScope.launch {
            if(isConnected()){
                _allUsers.value = NetworkResult.Loading()
                val response = repository.getDataFromAPIuser()
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }

}