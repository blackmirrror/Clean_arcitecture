package ru.blackmirrror.cleanarcitecture.data.storage

import android.content.Context
import ru.blackmirrror.cleanarcitecture.data.models.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"

class SharedPrefUserStorage(context: Context): UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "")?: "Default first name"
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "")?: "Default last name"
        return User(firstName = firstName, lastName = lastName)
    }
}