package by.tigertosh.newsapp_android.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import by.tigertosh.newsapp_android.data.api.TestRepo
import by.tigertosh.newsapp_android.data.models.retrofit.NewsResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: TestRepo) : ViewModel() {

    private val _allNews = MutableLiveData<NewsResponse>()
    val allNews: LiveData<NewsResponse> get() = _allNews

    init {
        getAllArticle()
    }

    fun getAllArticle() = viewModelScope.launch {
        repository.getAll().let {
            if (it.isSuccessful){
                _allNews.postValue(it.body())
            } else {
                Log.d("Network", "Field to load article: ${it.errorBody()}")
            }
        }
    }

}