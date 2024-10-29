package by.tigertosh.newsapp_android.data.api

import by.tigertosh.newsapp_android.data.models.retrofit.NewsResponse
import retrofit2.http.GET

import by.tigertosh.newsapp_android.data.utils.Constants.Companion.API_KEY
import retrofit2.http.Query
import java.util.Locale.IsoCountryCode

interface NewsService {

    @GET("/v2/everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("language") language: String = "ru",
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY,
        )

    @GET("/v2/top-headlines")
    suspend fun getHeadline(
        @Query("country") countryCode: IsoCountryCode,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY,
    )
}