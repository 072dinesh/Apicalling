package com.example.postdataproject.fragment.publicpostfromwordpress

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.postdataproject.R
import com.example.postdataproject.model.MekepdataItem
import com.example.postdataproject.model.ProductColor
import com.example.postdataproject.model.PublicdataItem
import com.example.postdataproject.model.WpTerm
import com.example.postdataproject.repository.RetroRepository
import com.example.postdataproject.util.BaseViewModel
import com.example.postdataproject.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModelPublic @Inject constructor(
    private val repository: RetroRepository,
    application: Application
) : BaseViewModel(application) {


    private val mContext = application

    private val _allUsers = MutableLiveData<NetworkResult<List<PublicdataItem>>>()
    val allUsers: LiveData<NetworkResult<List<PublicdataItem>>>
        get() = _allUsers


    private val _allUsersp = MutableLiveData<NetworkResult<List<WpTerm>>>()
    val allUsersp: LiveData<NetworkResult<List<WpTerm>>>
        get() = _allUsersp

    init {
        showAPImakeup()
        showAPImakeups()
    }

    private fun showAPImakeup() {
        viewModelScope.launch {
            if(isConnected()){
                _allUsers.value = NetworkResult.Loading()
                val response = repository.showAPIpublic()
                _allUsers.value = handleResponse(response)
            } else {
                _allUsers.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }


//    fun getdatafromApimakeup(query:String) {
//        viewModelScope.launch {
//            if(isConnected()){
//                _allUsers.value = NetworkResult.Loading()
//                val response = repository.getdatafromApimakeup(query)
//                _allUsers.value = handleResponse(response)
//            } else {
//                _allUsers.value = NetworkResult.Error(
//                    mContext.getString(R.string.no_Internet)
//                )
//            }
//        }
//    }
//
//


    private fun showAPImakeups() {
        viewModelScope.launch {
            if(isConnected()){
                _allUsersp.value = NetworkResult.Loading()
                val response = repository.showAPIword()
                _allUsersp.value = handleResponse(response)
            } else {
                _allUsersp.value = NetworkResult.Error(
                    mContext.getString(R.string.no_Internet)
                )
            }
        }
    }






}