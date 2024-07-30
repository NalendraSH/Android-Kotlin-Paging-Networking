package com.nanz.catto.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aci.viuit.utils.Resource
import com.nanz.catto.data.repository.MainRepository
import com.nanz.catto.data.response.CatResponse

class MainViewModel(private val mainRepository: MainRepository): ViewModel() {

    fun getCatList(page: Int, limit: Int): LiveData<Resource<List<CatResponse>>> {
        return mainRepository.getCatList(page, limit)
    }

}