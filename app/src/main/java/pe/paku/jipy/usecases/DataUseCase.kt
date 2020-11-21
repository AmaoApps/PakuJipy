package pe.paku.jipy.usecases

import pe.paku.jipy.data.model.GithubRepositoryModel
import pe.paku.jipy.data.model.ResultData
import pe.paku.jipy.repositories.DataRepository
import javax.inject.Inject

class DataUseCase
@Inject constructor(
    private val dataRepository: DataRepository
) {
    suspend fun getRepositories(): ResultData<GithubRepositoryModel> {
        val listaRepositories = dataRepository.getDataRemoteRepository()
        val resultData = if (!listaRepositories.isNullOrEmpty()){
            ResultData.Success(listaRepositories)
        } else {
            ResultData.Failed("Se encontró un Error, Intenta nuevamente")
        }

        return resultData
    }
}