package com.example.task_07.paging


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.task_07.api.ApiService
import com.example.task_07.models.ActiveCourse

class DataPagingSource(private val apiService: ApiService) : PagingSource<Int,ActiveCourse>(){
    override fun getRefreshKey(state: PagingState<Int, ActiveCourse>): Int? {
        return null
    }

    override suspend fun load(params:LoadParams<Int>): LoadResult<Int, ActiveCourse> {
        return try {
            val currentPage = params.key ?: 1
            val response = apiService.getAllData(currentPage)
            val data = response.body()?.active_courses?: emptyList()
            val responseData = mutableListOf<ActiveCourse>()
            responseData.addAll(data)
            LoadResult.Page(
                data = responseData,
                prevKey = if (currentPage == 1) null else -1,
                nextKey = currentPage.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}