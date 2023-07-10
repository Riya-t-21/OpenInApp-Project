package com.example.openinapp.Viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.demoretrofit.data.DataResponse
import com.example.demoretrofit.data.Links

class RecentLinksViewModel : ViewModel() {


    private val _recentLinks = MutableLiveData<List<Links>>()
    val recentLinks : LiveData<List<Links>> get() = _recentLinks

    // Function to handle the Retrofit response and extract the recentLinks
    fun handleResponse(response: DataResponse) {
        val data = response.data
        val links = data.recent_links
        _recentLinks.value = links
    }
}