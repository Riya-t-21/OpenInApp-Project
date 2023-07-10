package com.example.demoretrofit.retrofit

import com.example.demoretrofit.data.DataResponse

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface RetroServiceInterface {

    @GET("dashboardNew")
    fun getDashboardData(@Header("Authorization") token: String): Call<DataResponse>
}