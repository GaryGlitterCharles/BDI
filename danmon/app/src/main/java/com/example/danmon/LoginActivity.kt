package com.example.danmon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.danmon.databinding.ActivityLoginBinding
import com.example.danmon.databinding.ActivitySplashBinding
import com.example.danmon.utils.AppPreferencesHelper

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    private val mPrefHelper: AppPreferencesHelper by lazy {
        AppPreferencesHelper(getSharedPreferences("myapp", MODE_PRIVATE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        onCreateData()
    }

    private fun onCreateData() {
        binding.loginBtn.setOnClickListener {
            if (binding.userLoginEmail.text.isNullOrEmpty())
                Toast.makeText(this, "Please Enter Email Id", Toast.LENGTH_SHORT).show()
            else if (binding.userLoginPassword.text.isNullOrEmpty())
                Toast.makeText(this, "Please Enter password", Toast.LENGTH_SHORT).show()
            else {

                mPrefHelper.getAllUsers().forEach {
                    if (it.email == binding.userLoginEmail.text.toString() && it.password == binding.userLoginPassword.text
                            .toString()){
                        mPrefHelper.isUserLoggedIn = true
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish()
                        return@setOnClickListener
                    }
                }

                Toast.makeText(this, "user not register", Toast.LENGTH_SHORT).show()


            }
        }


        binding.signupText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}