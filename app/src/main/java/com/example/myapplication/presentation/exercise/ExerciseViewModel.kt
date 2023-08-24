package com.example.myapplication.presentation.exercise

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.repository.TestRepository
import com.example.myapplication.util.network.NetworkResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "ExerciseViewModel"

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val repository: TestRepository
) : ViewModel() {

    fun getTestString() {
        viewModelScope.launch {
            repository.apiTest("this String is from Watch!")
                .onStart {
                    // 값 받아오기 시작할때 처리, 로딩중 화면을 보여주면될듯
                    Log.d(TAG, "getTestString: 로딩중")
                }
                .onCompletion {
                    // 값 받아오기 끝났을때 처리, 로딩중 화면을 지우면될듯
                    Log.d(TAG, "getTestString: 로딩끝")
                }
                .catch {
                    // 예외 발생, 서버 에러나 기타 에러 처리
                    Log.d(TAG, "getTestString: 에러 ${it}")
                }
                .collect { response ->
                    // 받아온 값을 어떻게 할지
                    when(response){
                        is NetworkResponse.Success -> {
                            Log.d(TAG, "getTestString: 통신 결과 ${response.body}")
                        }

                        is NetworkResponse.ApiError -> {
                            Log.d(TAG, "getTestString: Api err: ${response.body}")
                        }

                        is NetworkResponse.NetworkError -> {
                            Log.d(TAG, "getTestString: Network err: ${response.error}")
                        }

                        is NetworkResponse.UnknownError -> {
                            Log.d(TAG, "getTestString: Unknown err: ${response.error}")
                        }
                    }
                }

        }
    }
}