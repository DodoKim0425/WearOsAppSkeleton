package com.example.myapplication.data.repository

import android.util.Log
import com.example.myapplication.data.model.ErrorResponse
import com.example.myapplication.data.model.Test
import com.example.myapplication.data.remote.ApiService
import com.example.myapplication.util.network.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

private const val TAG = "TestRepositoryImpl"
class TestRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TestRepository {
    override suspend fun apiTest(testString: String): Flow<NetworkResponse<Test, ErrorResponse>> {
        return flow {
            emit(apiService.apiTest())
        }
    }
}