package com.xendit.wordle.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordleViewModel : ViewModel() {

    var wordleLiveData1: MutableLiveData<String>
    var wordleLiveData2: MutableLiveData<String>
    var wordleLiveData3: MutableLiveData<String>
    var wordleLiveData4: MutableLiveData<String>
    var wordleLiveData5: MutableLiveData<String>
    var wordleLiveData6: MutableLiveData<String>
    var firstWordle:MutableLiveData<List<Char>>
    init {
        wordleLiveData1= MutableLiveData()
        wordleLiveData2= MutableLiveData()
        wordleLiveData3= MutableLiveData()
        wordleLiveData4= MutableLiveData()
        wordleLiveData5= MutableLiveData()
        wordleLiveData6= MutableLiveData()
        firstWordle=MutableLiveData()
    }

    fun getWordleLiveData1(): LiveData<String> {
        return wordleLiveData1
    }

    fun getWordleLiveData2(): LiveData<String> {
        return wordleLiveData2
    }

    fun getWordleLiveData3(): LiveData<String> {
        return wordleLiveData3
    }

    fun getWordleLiveData4(): LiveData<String> {
        return wordleLiveData4
    }

    fun getWordleLiveData5(): LiveData<String> {
        return wordleLiveData5
    }

    fun getWordleLiveData6(): LiveData<String> {
        return wordleLiveData6
    }
}