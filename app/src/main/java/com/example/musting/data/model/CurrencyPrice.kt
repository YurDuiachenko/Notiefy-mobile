package com.example.musting.data.model

import com.google.gson.annotations.SerializedName

data class CurrencyPrice(
    @SerializedName("symbol")
    val symbol: String,

    @SerializedName("price")
    val price: String
)