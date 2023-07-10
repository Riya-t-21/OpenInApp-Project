package com.example.openinappbyriya.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoretrofit.data.DataResponse
import com.example.demoretrofit.retrofit.RetroServiceInterface
import com.example.demoretrofit.retrofit.RetrofitInstance
import com.example.openinapp.Viewmodel.ActivityViewModel
import com.example.openinapp.adapter.TopLinkAdapter
import com.example.openinappbyriya.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.sql.DriverManager


class Top_Fragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TopLinkAdapter
    private lateinit var viewModel: ActivityViewModel
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_, container, false)

        recyclerView = view.findViewById(R.id.Recycle_top_links)
        val layoutManager = LinearLayoutManager(requireContext())
        recyclerView.layoutManager = layoutManager

        sharedPreferences = requireContext().getSharedPreferences("com.example.openinapp.PREFERENCES", Context.MODE_PRIVATE)

        adapter = TopLinkAdapter()
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(requireActivity()).get(ActivityViewModel::class.java)

        val apiService = RetrofitInstance.retrofit.create(RetroServiceInterface::class.java)

       // val token="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI"
        val token = sharedPreferences.getString("token", "")

        val call = apiService.getDashboardData("Bearer $token")
        call.enqueue(object : Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                if (response.isSuccessful) {
                    val dataResponse = response.body()
                    if (dataResponse != null) {
                        viewModel.handleResponse(dataResponse)
                        DriverManager.println(dataResponse.message)
                    }
                } else {
                    // Handle the error response
                    DriverManager.println("API request failed: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {
                // Handle the network failure
                DriverManager.println("API request failed: ${t.message}")
            }
        })

        viewModel.topLinks.observe(viewLifecycleOwner, { links ->
            // Update the adapter with the recent links
            adapter.setTopLinks(links)
        })






        return view

    }


}