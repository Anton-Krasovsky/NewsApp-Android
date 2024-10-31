package by.tigertosh.newsapp_android.data.api

import by.tigertosh.newsapp_android.data.models.retrofit.NewsResponse
import by.tigertosh.newsapp_android.data.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("/v2/everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("language") language: String = "ru",
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY,
        ): Response<NewsResponse>

    @GET("/v2/top-headlines")
    suspend fun getHeadline(
        @Query("country") countryCode: String = "ru",
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY,
    ): Response<NewsResponse>
}