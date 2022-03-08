package com.xendit.wordle.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WordleViewModel : ViewModel() {

    var wordleLiveData1: MutableLiveData<String>
    init {
        wordleLiveData1= MutableLiveData()
    }

    fun getWordleLiveData1(): LiveData<String> {
        return wordleLiveData1
    }
}