package pe.paku.jipy.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import pe.paku.jipy.data.api.ApiService
import pe.paku.jipy.utils.NetworkConstants
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


@InstallIn(ApplicationComponent::class)
@Module
object NetworkModule {

    @Provides
    fun providesBaseUrl() : String {
        return NetworkConstants.BASE_URL
    }

    @Provides
    fun providesLogginInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    fun providesHttpClient(logger: HttpLoggingInterceptor): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.addInterceptor(logger)
        okHttpClient.callTimeout(60, TimeUnit.SECONDS)
        okHttpClient.connectTimeout(60, TimeUnit.SECONDS)
        okHttpClient.writeTimeout(60, TimeUnit.SECONDS)
        okHttpClient.readTimeout(60, TimeUnit.SECONDS)
        return okHttpClient.build()
    }

    @Provides
    fun providesConvertorFactory(): Converter.Factory {
        return GsonConverterFactory.create()
    }

    @Provides
    fun providesRetrofit(baseURL: String, converterFactory: Converter.Factory, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(converterFactory)
            .client(okHttpClient)
            .build()
    }


    @Provides
    fun providesApiService(retrofit: Retrofit) : ApiService {
        return retrofit.create(ApiService::class.java)
    }


}