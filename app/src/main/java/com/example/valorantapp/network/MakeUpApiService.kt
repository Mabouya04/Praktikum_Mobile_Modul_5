package com.example.valorantapp.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://makeup-api.herokuapp.com/api/v1/"


private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MakeUpApiService {
    @GET("products.json")
    suspend fun getMakeUps(): List<MakeUp>
}

object MakeUpApi {
    val retrofitService: MakeUpApiService by lazy {
        retrofit.create(MakeUpApiService::class.java)
    }
}