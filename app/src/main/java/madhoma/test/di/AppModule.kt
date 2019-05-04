package madhoma.test.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import madhoma.test.BuildConfig
import madhoma.test.network.StateApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideGson() = GsonBuilder().create()


    companion object {
        const val CONNECTION_TIMEOUT = 45L
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {
        val okHttpClient = OkHttpClient.Builder().apply {
            retryOnConnectionFailure(true)
            readTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            addInterceptor(
                HttpLoggingInterceptor()
            )

        }.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BuildConfig.SERVER)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create()
            )
            .build()

        return retrofit
    }

    @Provides
    fun provideStateApi(retrofit: Retrofit) = retrofit.create(StateApi::class.java)
}