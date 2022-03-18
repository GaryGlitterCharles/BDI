package com.example.danmon.utils

import android.content.SharedPreferences
import android.util.Log
import com.example.danmon.model.UserObject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

import kotlin.collections.ArrayList


class AppPreferencesHelper(private val mPrefs: SharedPreferences) {
    var authToken: String
        get() = mPrefs.getString("USER-AUTH-TOKEN", "").toString()
        set(value) = mPrefs.edit().putString("USER-AUTH-TOKEN", value).apply()

    var fireBaseToken: String
        get() = mPrefs.getString("fireBaseToken", "").toString()
        set(value) = mPrefs.edit().putString("fireBaseToken", value).apply()

    var emailMobileNUmber: String
        get() = mPrefs.getString("emailMobileNUmber", "").toString()
        set(value) = mPrefs.edit().putString("emailMobileNUmber", value).apply()

    var password: String
        get() = mPrefs.getString("password", "").toString()
        set(value) = mPrefs.edit().putString("password", value).apply()

    var rememberMe: Boolean
        get() = mPrefs.getBoolean("rememberMe", false)
        set(value) = mPrefs.edit().putBoolean("rememberMe", value).apply()



    var locationName: String
        get() = mPrefs.getString("locationName", "").toString()
        set(value) = mPrefs.edit().putString("locationName", value).apply()

    var latitude: String
        get() = mPrefs.getString("USER-LAT", "").toString()
        set(value) = mPrefs.edit().putString("USER-LAT", value).apply()

    var longitude: String
        get() = mPrefs.getString("USER-LONG", "").toString()
        set(value) = mPrefs.edit().putString("USER-LONG", value).apply()

    var isUserLoggedIn: Boolean
        get() = mPrefs.getBoolean("isUserLoggedIn", false)
        set(value) = mPrefs.edit().putBoolean("isUserLoggedIn", value).apply()

//    var user: User?
//        get() = Gson().fromJson(mPrefs.getString("USER-OBJECT", ""), User::class.java) ?: User()
//        set(value) = mPrefs.edit().putString("USER-OBJECT", Gson().toJson(value).toString()).apply()

    fun isUserLogin(): Boolean {
        return !mPrefs.getString("USER-AUTH-TOKEN", "").equals("", true)
    }

    var userJson: String
        get() = mPrefs.getString("userJson", "[]").toString()
        set(value) = mPrefs.edit().putString("userJson", value).apply()

    fun saveUsers(list: ArrayList<UserObject>) {

        //mPrefs.edit().putString("userJson", Gson().toJson(list)).apply()
        userJson = Gson().toJson(list)

        Log.e("json", userJson)
    }

    fun saveUserObject(userObject: UserObject){
        val users = getAllUsers()
        users.add(userObject)
        saveUsers(users)
    }

    fun getAllUsers(): ArrayList<UserObject> {
        val type = object : TypeToken<ArrayList<UserObject>>() {}.type
        return Gson().fromJson(userJson, type)
    }

    fun clear() {
        val tempEmailMobile = emailMobileNUmber
        val tempPassword = password
        val tempRememberMe = rememberMe
        val tempLat = latitude
        val tempLng = longitude
        mPrefs.edit().clear().apply()
        if (tempRememberMe) {
            emailMobileNUmber = tempEmailMobile
            password = tempPassword
            rememberMe = tempRememberMe
        }
        latitude = tempLat
        longitude = tempLng
    }
}