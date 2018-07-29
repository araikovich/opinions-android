package com.example.tigranchilingarian.rateme.data.storage

interface PreferencesStorage {

    fun getCurrentUserId(): Int

    fun saveCurrentUserId(id: Int)

    fun setVerifyUser()

    fun isVerifyUser(): Boolean
}