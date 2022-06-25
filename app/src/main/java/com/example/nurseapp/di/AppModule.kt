package com.example.nurseapp.di


import com.example.nurseapp.data.network.ApiService
import com.example.nurseapp.data.repository.AppRepository
import com.example.nurseapp.data.repository.LocalDataSource
import com.example.nurseapp.data.repository.RemoteDataSource
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


val AppModule = module {
    
    single { AppRepository (get(), get()) }

    single { RemoteDataSource (get()) }

    single { LocalDataSource() }

    single {

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val retrofit = Retrofit.Builder()

            .baseUrl("https://6086fa75a3b9c200173b758e.mockapi.io/api/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .client(client)
            .build()
        retrofit
    }

    single {
        val retrofit = get() as Retrofit
        val loginApiService = retrofit.create(ApiService::class.java)

        loginApiService
    }

//    viewModel { RegesterViewModel (get()) }
//    viewModel { LoginViewModel (get()) }
//    viewModel { HomeViewModel (get()) }
}