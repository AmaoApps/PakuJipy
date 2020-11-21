package pe.paku.jipy.data.api

import pe.paku.jipy.data.model.GithubRepositoryModel
import pe.paku.jipy.utils.NetworkConstants
import retrofit2.http.GET

interface ApiService {

    @GET(NetworkConstants.URL_REPOSITORIES)
    suspend fun getRepositories() : GithubRepositoryModel

}