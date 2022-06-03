package mumtaz.binar.newsstaffjc.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mumtaz.binar.newsstaffjc.network.ApiNewsServices
import mumtaz.binar.newsstaffjc.network.ApiStaffServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsAppModule {
    private const val BASE_URL = "https://6254434289f28cf72b5aed04.mockapi.io/"

    private val logging: HttpLoggingInterceptor
        get() {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            return httpLoggingInterceptor.apply {
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            }
        }
    private val client = OkHttpClient.Builder().addInterceptor(logging).build()

    @Provides
    @Singleton
    fun provideRetrofitNews(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

    @Provides
    @Singleton
    fun provideNewsFromApi(retrofit: Retrofit): ApiNewsServices =
        retrofit.create(ApiNewsServices::class.java)

    @Provides
    @Singleton
    @Named("staff")
    fun provideStafFromApi(retrofit: Retrofit): ApiStaffServices =
        retrofit.create(ApiStaffServices::class.java)

}