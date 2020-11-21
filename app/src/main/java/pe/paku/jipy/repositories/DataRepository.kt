package pe.paku.jipy.repositories

import pe.paku.jipy.data.api.ApiService
import pe.paku.jipy.data.model.GithubRepositoryModel
import javax.inject.Inject

class DataRepository
@Inject constructor(

    private val apiService: ApiService

){
    suspend fun getDataRemoteRepository() : GithubRepositoryModel{
        return apiService.getRepositories()
    }
}