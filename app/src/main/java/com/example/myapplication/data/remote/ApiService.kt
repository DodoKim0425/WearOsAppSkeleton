package com.example.myapplication.data.remote

import com.example.myapplication.data.model.ErrorResponse
import com.example.myapplication.data.model.Test
import com.example.myapplication.util.network.NetworkResponse
import retrofit2.http.*

interface ApiService {
    @GET("/posts/1")
    suspend fun apiTest(): NetworkResponse<Test, ErrorResponse>
}