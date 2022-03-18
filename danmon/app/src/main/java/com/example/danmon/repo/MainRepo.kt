package com.example.danmon.repo

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.danmon.api.ApiService
import com.example.danmon.api.BackendService
import com.example.danmon.model.MainPageResponseItem
import com.example.danmon.model.MainPageResponseX
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainRepo {

    private val apiService = ApiService.client.create(BackendService::class.java)

    fun getNormalUser(ctx: Context, dataresponse: MutableLiveData<MainPageResponseX>) {
        val call = apiService.mainPage()
        call.enqueue(object : Callback, retrofit2.Callback<MainPageResponseX> {
            override fun onResponse(call: Call<MainPageResponseX>, response: Response<MainPageResponseX>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        dataresponse.value = response.body()
                    }
                }
            }

            override fun onFailure(call: Call<MainPageResponseX>, t: Throwable) {
                Toast.makeText(ctx, "api failed", Toast.LENGTH_SHORT).show()

            }


        })
    }
}