package com.example.newsapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.models.NewsResponse
import com.example.newsapp.repository.NewsRepository
import com.example.newsapp.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(val newsrepository: NewsRepository) : ViewModel() {

    val breakingNewsMutableLiveData: MutableLiveData<Resource<NewsResponse>> = MutableLiveData()
    var breakingNewsPage = 1

    init {
        getBreakingNews("us")
    }
    fun getBreakingNews(countryCode: String)= viewModelScope.launch{
        breakingNewsMutableLiveData.postValue(Resource.Loading())
        val response = newsrepository.getBreakingNews(countryCode, breakingNewsPage)
        breakingNewsMutableLiveData.postValue(handleBreakingNewsResponse(response))
    }

    private fun handleBreakingNewsResponse(response: Response<NewsResponse>): Resource<NewsResponse>{
        if(response.isSuccessful){
            response.body()?.let {
                return Resource.Success(it)
            }
        }
        return  Resource.Error(response.message())
    }
}