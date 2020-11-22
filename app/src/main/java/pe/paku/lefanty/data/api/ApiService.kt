package pe.paku.lefanty.data.api

import pe.paku.lefanty.data.model.GithubRepositoryModel
import pe.paku.lefanty.utils.NetworkConstants
import retrofit2.http.GET

interface ApiService {

    @GET(NetworkConstants.URL_REPOSITORIES)
    suspend fun getRepositories() : GithubRepositoryModel

}