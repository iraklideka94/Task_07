package com.example.task_07.api

import com.example.task_07.models.RetData
import com.example.task_07.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getAllData(@Query("page") page:Int): Response<RetData>
}