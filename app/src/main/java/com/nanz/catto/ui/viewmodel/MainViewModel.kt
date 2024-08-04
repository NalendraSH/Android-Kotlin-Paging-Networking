package com.nanz.catto.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aci.viuit.utils.Resource
import com.nanz.catto.data.repository.MainRepository
import com.nanz.catto.data.response.CatResponse

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    val catListPaging: LiveData<PagingData<CatResponse>> =
        mainRepository.getCatListPaging().cachedIn(viewModelScope)

    fun getCatList(page: Int, limit: Int): LiveData<Resource<List<CatResponse>>> {
        return mainRepository.getCatList(page, limit)
    }

}