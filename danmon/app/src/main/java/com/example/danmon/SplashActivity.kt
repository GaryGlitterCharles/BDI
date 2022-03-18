package com.example.danmon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.example.danmon.databinding.ActivitySplashBinding
import com.example.danmon.model.UserObject
import com.example.danmon.utils.AppPreferencesHelper
import com.example.danmon.utils.AppUtils
import com.google.gson.Gson
import java.lang.NullPointerException

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding

    private val mPrefHelper: AppPreferencesHelper by lazy {
        AppPreferencesHelper(getSharedPreferences("myapp", MODE_PRIVATE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        hideSystemBars()
        binding = ActivitySplashBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)



        Handler(mainLooper).postDelayed({

            if (mPrefHelper.isUserLoggedIn) {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
            } else {
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 2000)
    }
    private fun hideSystemBars() {
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        val windowInsetsController =
            ViewCompat.getWindowInsetsController(window.decorView) ?: return
        // Configure the behavior of the hidden system bars
        windowInsetsController.systemBarsBehavior =
            WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        // Hide both the status bar and the navigation bar
        windowInsetsController.hide(WindowInsetsCompat.Type.systemBars())
    }
}