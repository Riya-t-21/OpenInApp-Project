package com.example.demoretrofit.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance
{

        // api/v1/dashboardNew
    private const  val Base_Url = "https://api.inopenapp.com/api/v1/"

    val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(Base_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

          //  val apiService = retrofit.create(RetroServiceInterface::class.java)
        }



