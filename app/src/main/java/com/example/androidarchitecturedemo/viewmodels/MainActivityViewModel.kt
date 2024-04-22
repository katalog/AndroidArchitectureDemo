package com.example.androidarchitecturedemo.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.model.EarthquakeDto
import com.example.domain.UsecaseGetEarthquakeData
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivityViewModel : ViewModel(), KoinComponent {
    val usecase: UsecaseGetEarthquakeData by inject()
    val eqItems: MutableLiveData<EarthquakeDto> by lazy {
        MutableLiveData<EarthquakeDto>()
    }

    init {
        //fetchDemoData()
    }

    fun fetchDemoData() {
        viewModelScope.launch {
            usecase.getDemoData().collect { earthquakeDto ->
//                earthquakeDto.features.forEach {
//                    Log.d("&&", "&& $it")
//                }
                eqItems.postValue(earthquakeDto)
            }
        }
    }
}