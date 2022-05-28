package com.amazida.harilibur.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private val BASE_URL = "https://raw.githubusercontent.com/zidaaja/PublicHoliday2022/main/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface HariLiburServiceApi {
    @GET("holiday.json")
    suspend fun getData(): List<HariLibur>
}

object HariLiburApi {
    val retrofitServiceApi: HariLiburServiceApi by lazy {
        retrofit.create(HariLiburServiceApi::class.java)
    }
}