package com.example.musting.data.repository

import androidx.room.*
import com.example.musting.data.model.CurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(character: CurrencyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(characters: List<CurrencyEntity>)

    @Query("SELECT * FROM currency")
    fun getAll(): Flow<List<CurrencyEntity>>

    @Query("SELECT * FROM currency WHERE id = :id")
    suspend fun getById(id: Int): CurrencyEntity?

    @Update
    suspend fun update(character: CurrencyEntity)

    @Delete
    suspend fun delete(character: CurrencyEntity)

    @Query("DELETE FROM currency")
    suspend fun deleteAll()
}
