package com.example.danmon.utils

import android.content.Context
import android.preference.PreferenceManager
import java.security.AccessControlContext

/**
 * Created by Nimish Nandwana on 17/03/2022.
 * Description -
 */

object AppUtils {


    fun getPrefBoolean(key:String,context: Context): Boolean {
        val prefrences=PreferenceManager.getDefaultSharedPreferences(context)
        return prefrences.getBoolean(key,false)
    }
}