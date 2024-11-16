package com.example.musting.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class CurrencyEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
    val shortName: String,
    val fullName: String,
    val cost: Double,
    val grow: Double
)