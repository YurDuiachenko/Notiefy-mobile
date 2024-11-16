package com.example.musting.data.store


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.musting.data.repository.CurrencyDao
import com.example.musting.data.model.CurrencyEntity
import com.example.musting.data.converters.Converters

@Database(entities = [CurrencyEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CurrencyDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "currency_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

