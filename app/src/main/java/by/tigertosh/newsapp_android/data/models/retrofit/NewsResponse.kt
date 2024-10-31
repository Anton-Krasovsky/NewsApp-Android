package by.tigertosh.newsapp_android.data.models.retrofit


data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)