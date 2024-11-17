package com.example.musting.data.repository

import com.example.musting.data.api.BinanceApi
import com.example.musting.data.model.CurrencyEntity
import com.example.musting.data.model.CurrencyPrice
import com.example.musting.data.model.CurrencyInfo
import kotlinx.coroutines.flow.Flow
import retrofit2.Call

class CurrencyRepository(
    private val api: BinanceApi,
    private val dao: CurrencyDao
) {

    fun fetchAll(): Call<List<CurrencyPrice>> {
        return api.getAllPrices()
    }

    fun fetchCurrencyBySymbol(symbol: String): Call<CurrencyInfo> {
        return api.getCurrentBySymbol24hr(symbol)
    }

    suspend fun insertAll(characters: List<CurrencyEntity>) {
        dao.insertAll(characters)
    }

    fun getAll(): Flow<List<CurrencyEntity>> {
        return dao.getAll()
    }

    suspend fun deleteAll() {
        dao.deleteAll()
    }
}
