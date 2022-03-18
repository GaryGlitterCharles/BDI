package com.example.danmon.api

import com.example.danmon.model.MainPageResponseX
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by Nimish Nandwana on 17/03/2022.
 * Description -
 */

interface BackendService {

    @GET("photos")
    fun mainPage(): Call<MainPageResponseX>
}