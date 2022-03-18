package com.example.danmon.view_model

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.danmon.model.MainPageResponseX
import com.example.danmon.repo.MainRepo


class HomeViewModel : ViewModel() {
    lateinit var ctx: Context
    var mainRepo = MainRepo();
    var normalUser = MutableLiveData<MainPageResponseX>()

    fun getNormalUser() {
        mainRepo.getNormalUser(ctx, normalUser)
    }
}