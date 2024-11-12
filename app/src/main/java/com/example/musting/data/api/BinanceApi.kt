package com.example.musting.data.api

import com.example.musting.data.model.CurrencyPrice
import com.example.musting.data.model.CurrencyInfo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BinanceApi {
    @GET("ticker/24hr")
    fun getCurrentBySymbol24hr(@Query("symbol") symbol: String): Call<CurrencyInfo>

    @GET("ticker/price")
    fun getAllPrices(): Call<List<CurrencyPrice>>
}