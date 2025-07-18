package com.unovil.tardyscan.di

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.unovil.tardyscan.userDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPreferencesRepository @Inject constructor(
    @ApplicationContext private val context: Context
) {
    companion object {
        val THEME_KEY = stringPreferencesKey("theme")
    }

    val themeFlow: Flow<String> = context.userDataStore.data.map { settings ->
        settings[THEME_KEY] ?: "SYSTEM"
    }

    suspend fun setTheme(theme: String) {
        context.userDataStore.edit { settings ->
            settings[THEME_KEY] = theme
        }
    }
}