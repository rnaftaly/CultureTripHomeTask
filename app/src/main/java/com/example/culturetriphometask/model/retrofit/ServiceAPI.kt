package com.example.culturetriphometask.model.retrofit

import retrofit2.Response
import retrofit2.http.*


interface ServiceAPI {
        // ...

        @GET("home-assignment/response.json")
        suspend fun getArticles(): Response<Articles>

    }

