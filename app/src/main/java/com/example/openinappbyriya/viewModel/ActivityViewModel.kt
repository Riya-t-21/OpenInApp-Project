package com.example.openinapp.Viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.example.demoretrofit.data.DataResponse
import com.example.demoretrofit.data.Links

import com.example.demoretrofit.retrofit.RetroServiceInterface
import com.example.demoretrofit.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

class ActivityViewModel : ViewModel() {


    private val _topLinks = MutableLiveData<List<Links>>()
    val topLinks: LiveData<List<Links>> get() = _topLinks

    // Function to handle the Retrofit response and extract the recentLinks
    fun handleResponse(response: DataResponse) {
        val data = response.data
        val links = data.top_links
        _topLinks.value = links
    }


}