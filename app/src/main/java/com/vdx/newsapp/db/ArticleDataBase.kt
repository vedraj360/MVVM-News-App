package com.vdx.newsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vdx.newsapp.models.Article

@TypeConverters(Converters::class)
@Database(entities = [Article::class], version = 1)
abstract class ArticleDataBase : RoomDatabase() {

    abstract fun getArticle(): ArticleDao

    companion object {
        @Volatile
        private var instance: ArticleDataBase? = null
        private val LOCK = Any()


        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context, ArticleDataBase::class.java, "article_db.db"
        ).build()
    }
}