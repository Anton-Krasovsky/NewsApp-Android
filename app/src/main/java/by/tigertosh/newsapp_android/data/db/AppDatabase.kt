package by.tigertosh.newsapp_android.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import by.tigertosh.newsapp_android.data.models.retrofit.Article

//@Database(entities = [Article::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun dao(): DAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(LOCK){
            INSTANCE ?: createDatabase(context).also { INSTANCE = it }
        }

        fun createDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "article_db"
                )
                    .build()


        }
    }
}