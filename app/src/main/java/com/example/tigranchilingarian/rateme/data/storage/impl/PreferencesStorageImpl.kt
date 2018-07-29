package com.example.tigranchilingarian.rateme.data.storage.impl

import android.content.Context
import android.content.SharedPreferences
import com.example.tigranchilingarian.rateme.data.storage.PreferencesStorage
import com.google.gson.Gson

class PreferencesStorageImpl(context: Context, gson: Gson) : PreferencesStorage {

    private val NAME = "opinions_prefs"
    private val USER_ID = "user_id"
    private val VERIFY_USER = "verify_user"

    private val sharedPrefs: SharedPreferences

    init {
        sharedPrefs = context.getSharedPreferences(NAME, Context.MODE_PRIVATE)
    }


    override fun getCurrentUserId(): Int = sharedPrefs.getInt(USER_ID, -1)


    override fun saveCurrentUserId(id: Int) {
        sharedPrefs.edit().putInt(USER_ID, id)
    }

    override fun setVerifyUser() {
        sharedPrefs.edit().putBoolean(VERIFY_USER, true)
    }

    override fun isVerifyUser(): Boolean = sharedPrefs.getBoolean(VERIFY_USER, false)

}