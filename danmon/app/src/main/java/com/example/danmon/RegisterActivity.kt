package com.example.danmon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.example.danmon.databinding.ActivityRegisterBinding
import com.example.danmon.model.UserObject
import com.example.danmon.utils.AppPreferencesHelper
import com.example.danmon.utils.AppUtils

class RegisterActivity : AppCompatActivity() {

    lateinit var binding:ActivityRegisterBinding

    private val mPrefHelper: AppPreferencesHelper by lazy {
        AppPreferencesHelper(getSharedPreferences("myapp", MODE_PRIVATE))
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        onCreateData()
    }

    private fun onCreateData() {
        binding.signupBtn.setOnClickListener {
            if(binding.userName.text.isNullOrEmpty())
                Toast.makeText(this, "Please Enter USer Name", Toast.LENGTH_SHORT).show()

            else if(binding.userEmail.text.isNullOrEmpty())
                Toast.makeText(this, "Please Enter Email Id", Toast.LENGTH_SHORT).show()

            else if(binding.userPassword.text.isNullOrEmpty())
                Toast.makeText(this, "Please Enter password", Toast.LENGTH_SHORT).show()

            else if(binding.userType.text.isNullOrEmpty())
                Toast.makeText(this, "Please Enter user Type", Toast.LENGTH_SHORT).show()

            else{
                mPrefHelper.getAllUsers().forEach {
                    if (it.email == binding.userEmail.text.toString()){
                        Toast.makeText(this, "User ALreday Existed", Toast.LENGTH_SHORT).show()
                        return@setOnClickListener
                    }
                }

                mPrefHelper.saveUserObject(UserObject(
                    binding.userName.text.toString(),
                    Math.random().toInt(),
                    binding.userEmail.text.toString(),
                    binding.userPassword.text.toString(),
                    binding.userType.text.toString(),
                ))

                mPrefHelper.isUserLoggedIn = true

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

            }
        }



        binding.loginText.setOnClickListener{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}