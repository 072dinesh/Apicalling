package com.example.postdataproject.di

import com.example.postdataproject.repository.RetroRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModel {

    //    val baseUrl = "https://api.spoonacular.com/recipes/716429/information?includeNutrition=false"
    val baseUrl = "https://api.coindesk.com"
   // val url2 = "https://randomuser.me"
    //val baseUrl ="https://randomuser.me/api/"
val base2 = "https://randomuser.me"

    val logging = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {

        return OkHttpClient.Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()
    }
    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }



    @Singleton
    @Provides
    fun provideRetrofitInstance(

        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(
                //"https://api.coindesk.com"
                //base2
                //baseUrl
                //"http://universities.hipolabs.com"
                //"https://datausa.io",
                //"https://www.thecocktaildb.com"
            //"https://house-stock-watcher-data.s3-us-west-2.amazonaws.com"
            //"http://makeup-api.herokuapp.com"
            "https://techcrunch.com"


            )
            .client(okHttpClient)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }



    @Singleton
    @Provides
    fun provideStarterTemplateApiService(retrofit: Retrofit): RetroServieInstance {
        return retrofit.create(RetroServieInstance::class.java)
    }


    @Singleton
    @Provides
    fun provideDashboardDataSource(dashboardApi: RetroServieInstance): RetroRepository {
        return RetroRepository(dashboardApi)
    }
}