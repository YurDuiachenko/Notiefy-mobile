import android.content.Context
import android.content.SharedPreferences
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings_store")

class SettingsStore(private val context: Context) {

    companion object {
        private const val PREF_USER_NAME = "user_name"
        private const val PREF_DARK_MODE = "dark_mode"
        private val EMAIL_KEY = stringPreferencesKey("email")
        private val LANGUAGE_KEY = booleanPreferencesKey("language")
    }

    private val sharedPref: SharedPreferences = context.getSharedPreferences("settings_pref", Context.MODE_PRIVATE)

    fun getUserName(): String? = sharedPref.getString(PREF_USER_NAME, null)

    fun saveUserName(userName: String) = sharedPref.edit().putString(PREF_USER_NAME, userName).apply()

    fun getDarkMode(): Boolean = sharedPref.getBoolean(PREF_DARK_MODE, false)

    fun saveDarkMode(isDarkMode: Boolean) = sharedPref.edit().putBoolean(PREF_DARK_MODE, isDarkMode).apply()


    fun getEmail(): Flow<String?> = context.dataStore.data.map { prefs ->
        prefs[EMAIL_KEY]
    }

    suspend fun saveEmail(email: String) = context.dataStore.edit { prefs ->
        prefs[EMAIL_KEY] = email
    }

    fun getLanguage(): Flow<Boolean> = context.dataStore.data.map { prefs ->
        prefs[LANGUAGE_KEY] ?: true
    }

    suspend fun saveLanguage(isEnglish: Boolean) = context.dataStore.edit { prefs ->
        prefs[LANGUAGE_KEY] = isEnglish
    }
}
