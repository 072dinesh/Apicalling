package com.example.postdataproject.fragment.makeupbrand

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postdataproject.R
import com.example.postdataproject.model.MekepdataItem
import com.example.postdataproject.model.ProductColor
import com.example.postdataproject.model.TestdataItem
import com.example.postdataproject.model.makeitem
import com.example.postdataproject.repository.RetroRepository
import com.example.postdataproject.util.BaseViewModel
import com.example.postdataproject.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject




@RequiresApi(Build.VERSION_CODES.M)
@HiltViewModel
class ViewModelMakeup @Inject constructor(
    private val repository: RetroRepository,
    application: Application
) : BaseViewModel(application) {


    private val mContext = application

    private val _allUsers = MutableLiveData<NetworkResult<List<MekepdataItem>>>()
    val allUsers: LiveData<NetworkResult<List<MekepdataItem>>>
        get() = _allUsers


    private val _allUsersp = MutableLiveData<NetworkResult<List<ProductColor>>>()
    val allUsersp: LiveData<NetworkResult<List<ProductColor>>>
        get() = _allUsersp

    init {
        showAPImakeup()
        showAPImakeups()
    }

    private fun showAPImakeup() {
        viewModelScope.launch {
            if(isConnected()){
                _allUsers.value = NetworkResult.Loading()
                val response = repository.showAPImakeup()
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }


    fun getdatafromApimakeup(query:String) {
        viewModelScope.launch {
            if(isConnected()){
                _allUsers.value = NetworkResult.Loading()
                val response = repository.getdatafromApimakeup(query)
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


    private fun showAPImakeups() {
        viewModelScope.launch {
            if(isConnected()){
                _allUsersp.value = NetworkResult.Loading()
                val response = repository.showAPImakeups()
                _allUsersp.value = handleResponse(response)
            } else {
                _allUsersp.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }

//
//    fun getdatafromApimakeups(query:String) {
//        viewModelScope.launch {
//            if(isConnected()){
//                _allUsersp.value = NetworkResult.Loading()
//                val response = repository.getdatafromApimakeups(query)
//                _allUsersp.value = handleResponse(response)
//            } else {
//                _allUsersp.value = NetworkResult.Error(
//                    mContext.getString(R.string.no_Internet)
//                )
//            }
//        }
//    }




}