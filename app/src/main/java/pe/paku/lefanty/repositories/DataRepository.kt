package pe.paku.lefanty.repositories

import pe.paku.lefanty.data.api.ApiService
import pe.paku.lefanty.data.model.GithubRepositoryModel
import javax.inject.Inject

class DataRepository
@Inject constructor(

    private val apiService: ApiService

){
    suspend fun getDataRemoteRepository() : GithubRepositoryModel{
        return apiService.getRepositories()
    }
}