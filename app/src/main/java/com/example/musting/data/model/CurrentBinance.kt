package com.example.musting.data.model

import com.google.gson.annotations.SerializedName

data class CurrentBinance(
    @SerializedName("symbol")
    val symbol: String,

    @SerializedName("priceChangePercent")
    val priceChangePercent: String,

    @SerializedName("lastPrice")
    val lastPrice: String,
)
