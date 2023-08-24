package com.example.myapplication.data.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) {

}