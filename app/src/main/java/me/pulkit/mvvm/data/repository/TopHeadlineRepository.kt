package me.pulkit.mvvm.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import me.pulkit.mvvm.data.api.NetworkService
import me.pulkit.mvvm.data.model.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TopHeadlineRepository @Inject constructor(private val networkService: NetworkService) {

    fun getTopHeadlines(country: String): Flow<List<Article>> {
        return flow {
            emit(networkService.getTopHeadlines(country))
        }.map {
            it.articles
        }
    }

}