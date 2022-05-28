package com.amazida.harilibur.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.amazida.harilibur.network.HariLibur
import com.amazida.harilibur.network.HariLiburApi
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {
    private val _listdata = MutableLiveData<List<HariLibur>>()
    val listdata: LiveData<List<HariLibur>> = _listdata

    private val _datatunggal = MutableLiveData<HariLibur>()
    val datatunggal: LiveData<HariLibur> = _datatunggal

    fun getData() {
        viewModelScope.launch {
            try {
                _listdata.value = HariLiburApi.retrofitServiceApi.getData()
                Log.d("Berhasil", listdata.value.toString())
            } catch (e: Exception) {
                _listdata.value = listOf()
                Log.d("adakesalahan", e.stackTraceToString())
            }
        }
    }

    fun convertToString(list: List<String>): String {
        return list.joinToString("\n \n")
    }

    fun onHariLiburClicked(hariLibur: HariLibur){
        _datatunggal.value = hariLibur
    }
}