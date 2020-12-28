package com.example.appserba.data.repository

import com.example.appserba.data.model.ActionState
import com.example.appserba.data.model.News
import com.example.appserba.data.remote.NewsServices
import com.example.appserba.data.remote.RetrofitApi
import retrofit2.await

class NewsRepository {
    private val newsServices: NewsServices by lazy { RetrofitApi.newsService() }

    suspend fun listNews() : ActionState<List<News>> {
        return try {
            val list = newsServices.listNews().await()
            ActionState(list.results)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailNews(url: String) : ActionState<News> {
        return try {
            val list = newsServices.detailNews(url).await()
            ActionState(list.results.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchNews(query: String) : ActionState<List<News>> {
        return try {
            val list = newsServices.searchNews(query).await()
            ActionState(list.results)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

}