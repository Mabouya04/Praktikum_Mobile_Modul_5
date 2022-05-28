package com.example.valorantapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.valorantapp.network.MakeUp
import com.example.valorantapp.network.MakeUpApi
import kotlinx.coroutines.launch

enum class MakeUpApiStatus {LOADING, ERROR, DONE}

class MakeUpViewModel : ViewModel(){

    private val _status = MutableLiveData<MakeUpApiStatus>()
    val status: LiveData<MakeUpApiStatus> = _status

    private val _makeups = MutableLiveData<List<MakeUp>>()
    val makeups: LiveData<List<MakeUp>> = _makeups

    private val _makeup = MutableLiveData<MakeUp?>()
    val makeup : LiveData<MakeUp?> = _makeup


    fun getMakeUpList(){
        viewModelScope.launch {
            _status.value = MakeUpApiStatus.LOADING
            try {
                _makeups.value = MakeUpApi.retrofitService.getMakeUps()
                _status.value = MakeUpApiStatus.DONE
            } catch (e: Exception){
                _status.value = MakeUpApiStatus.ERROR
                _makeups.value= listOf()
                Log.e("Pesan Error :", "${e.message}")
            }
        }
    }
    fun onMakeUpClicked(makeUp: MakeUp){
        _makeup.value = makeUp
    }
}