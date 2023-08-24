package com.example.myapplication.data.repository

import com.example.myapplication.data.model.ErrorResponse
import com.example.myapplication.data.model.Test
import com.example.myapplication.util.network.NetworkResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.Query

interface TestRepository {
    suspend fun apiTest(@Query("testString") testString: String): Flow<NetworkResponse<Test, ErrorResponse>>
}