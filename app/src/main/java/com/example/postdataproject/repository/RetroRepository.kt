package com.example.postdataproject.repository

import com.example.postdataproject.di.RetroServieInstance
import com.example.postdataproject.model.*
import retrofit2.Response
import javax.inject.Inject

class RetroRepository @Inject constructor(private val retroInstance: RetroServieInstance) {

    suspend fun getDataFromAPIso(): Response<Randoms> {
        return retroInstance.getDataFromAPIso()
    }

    suspend fun getdatafromApis(query: String): Response<List<TestdataItem>>{
        return retroInstance.getdatafromApis(query)
    }
    suspend fun showAPI():Response<List<TestdataItem>>{
        return retroInstance.showAPI()
    }
    suspend fun getDataFromAPIuser():Response<random> {
        return retroInstance.getDataFromAPIuser()
    }

    suspend fun getdatafromApius(): Response<usdata>{
        return retroInstance.getdatafromApius()
    }

    suspend fun getdatafromApiCocktail(query: String): Response<Cocktaildata>{
        return retroInstance.getdatafromApiCocktail(query)
    }

    suspend fun showAPIcocktails(): Response<Cocktaildata>{
        return retroInstance.showAPIcocktails()
    }

    suspend fun showAPIcongress(): Response<List<CongressdataItem>>{
        return retroInstance.showAPIcongress()
    }


    suspend fun getdatafromApimakeup(query: String): Response<List<MekepdataItem>>{
        return retroInstance.getdatafromApimakeup(query)
    }

    suspend fun showAPImakeup(): Response<List<MekepdataItem>>{
        return retroInstance.showAPImakeup()
    }


//
//    suspend fun getdatafromApimakeups(query: String): Response<List<ProductColor>>{
//        return retroInstance.getdatafromApimakeups(query)
//    }

    suspend fun showAPImakeups(): Response<List<ProductColor>>{
        return retroInstance.showAPImakeups()
    }


    suspend fun showAPIpublic(): Response<List<PublicdataItem>>{
        return retroInstance.showAPIpublic()
    }

    suspend fun showAPIword(): Response<List<WpTerm>>{
        return retroInstance.showAPIword()
    }

//    suspend fun showAPIus():Response<usdata>{
//        return retroInstance.showAPIus()
//    }



}