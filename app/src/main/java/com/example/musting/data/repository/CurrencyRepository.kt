package com.example.musting.data.repository

import com.example.musting.data.api.BinanceApi
import com.example.musting.data.model.CurrencyPrice
import com.example.musting.data.model.CurrencyInfo
import retrofit2.Call

class CurrencyRepository(private val api: BinanceApi) {

    fun getAllPrices(): Call<List<CurrencyPrice>> {
        return api.getAllPrices()
    }

    fun getCurrencyData(symbol: String): Call<CurrencyInfo> {
        return api.getCurrentBySymbol24hr(symbol)
    }
}
