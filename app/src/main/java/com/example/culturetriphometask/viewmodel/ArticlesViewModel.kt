package com.example.culturetriphometask.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.culturetriphometask.model.Article
import com.example.culturetriphometask.model.retrofit.mainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticlesViewModel(): ViewModel() {

    val repo:mainRepository
    var listLiveData: MutableLiveData<ArrayList<Article>>


    init {
         repo =mainRepository()
         listLiveData = repo.getMutbleLiveData()
    }


    fun Articles()

    {
        CoroutineScope(Dispatchers.IO).launch{
            repo.getArticlesFromAPI()

        }

    }

    fun observeLiveData():MutableLiveData<ArrayList<Article>>

    {

        return repo.getMutbleLiveData()

    }


}