package pe.paku.lefanty.data.model

sealed class ResultData<out T> (
    val data: T? = null,
    val message: String? = null
){
    data class Success<T>(var dataSuccess: T?): ResultData<T>(dataSuccess)
    data class Loading(val nothing: Nothing? = null): ResultData<Nothing>()
    data class Failed(val messageFailed: String? = null): ResultData<Nothing>()
    data class Exception(val messageException: String? = null) : ResultData<Nothing>()


}