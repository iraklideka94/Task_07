package com.example.task_07.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.example.task_07.api.ApiService
import com.example.task_07.paging.DataPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DataViewModel @Inject constructor(private val apiService: ApiService): ViewModel() {
    val listData = Pager(PagingConfig(pageSize = 1)){
          DataPagingSource(apiService)
    }.flow.cachedIn(viewModelScope)
}