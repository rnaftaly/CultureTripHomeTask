package com.example.culturetriphometask.model.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {
    const val BASE_URL = "https://cdn.theculturetrip.com/"

    fun makeRetrofitService(): ServiceAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ServiceAPI::class.java)
    }
}