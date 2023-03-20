package com.example.postdataproject.fragment.univarcity

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postdataproject.R
import com.example.postdataproject.model.TestdataItem
import com.example.postdataproject.repository.RetroRepository
import com.example.postdataproject.util.BaseViewModel
import com.example.postdataproject.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


@RequiresApi(Build.VERSION_CODES.M)
@HiltViewModel
class ViewModelUni @Inject constructor(
    private val repository: RetroRepository,
    application: Application
) : BaseViewModel(application) {


    private val mContext = application

    private val _allUsers = MutableLiveData<NetworkResult<List<TestdataItem>>>()
    val allUsers: LiveData<NetworkResult<List<TestdataItem>>>
        get() = _allUsers

    init {
        getAllUsers()
    }

    private fun getAllUsers() {
        viewModelScope.launch {
            if(isConnected()){
                _allUsers.value = NetworkResult.Loading()
                val response = repository.showAPI()
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }


     fun getAllUserss(query:String) {
        viewModelScope.launch {
            if(isConnected()){
                _allUsers.value = NetworkResult.Loading()
                val response = repository.getdatafromApis(query)
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }


//    @RequiresApi(Build.VERSION_CODES.M)
//    fun getPost3(query:String) {
//
//
//        viewModelScope.launch {
//            myResponseViewuniver.value = NetworkResult.Loading()
//
//            if (isConnected()) {
//
//
//                val response:Response<List<TestdataItem>> = repository.getdatafromApis(query)
//                myResponseViewuniver.value = handleResponse(response)
//
//
//            } else {
//                myResponseViewuniver.value = NetworkResult.Error(
//                    mContext.getString(R.string.no_Internet)
//                )
//            }
//
//
//        }
//    }


}