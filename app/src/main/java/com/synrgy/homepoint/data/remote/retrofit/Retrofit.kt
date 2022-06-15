package com.synrgy.homepoint.data.remote.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit {
    fun getRetroClientInstance(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl("https://homepoint-server-staging.herokuapp.com/api/v1/users/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}