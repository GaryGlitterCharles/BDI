package com.example.danmon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.danmon.adapter.UserAdapter
import com.example.danmon.databinding.ActivityLoginBinding
import com.example.danmon.databinding.ActivityMainBinding
import com.example.danmon.utils.AppPreferencesHelper

class MainActivity : AppCompatActivity() {
    private val mPrefHelper: AppPreferencesHelper by lazy {
        AppPreferencesHelper(getSharedPreferences("myapp", MODE_PRIVATE))
    }

    lateinit var binding: ActivityMainBinding
    lateinit var adapter:UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        onCreateData()
    }

    private fun onCreateData() {
        adapter=UserAdapter(this,mPrefHelper.getAllUsers())
        binding.userTypeRecylerView.adapter=adapter
        binding.logout.setOnClickListener {
            mPrefHelper.isUserLoggedIn = false
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

        }
    }
}