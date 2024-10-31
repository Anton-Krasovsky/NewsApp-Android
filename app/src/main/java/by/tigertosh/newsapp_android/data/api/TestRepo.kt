package by.tigertosh.newsapp_android.data.api

import javax.inject.Inject

class TestRepo @Inject constructor(private val service: NewsService) {

    suspend fun getAll() = service.getHeadline()
}