package com.example.nurseapp.di


import com.example.nurseapp.data.network.ApiService
import com.example.nurseapp.data.repository.AppRepository
import com.example.nurseapp.data.repository.LocalDataSource
import com.example.nurseapp.data.repository.RemoteDataSource
import com.example.nurseapp.ui.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


val appModule = module {

    factory<AppRepository> { get() }
    factory<RemoteDataSource> { get() }

    single { LocalDataSource() }

    single { AppRepository(get(), get()) }

    single { RemoteDataSource (get()) }


    single {
        val retrofit = get() as Retrofit
        val loginApiService = retrofit.create(ApiService::class.java)

        loginApiService
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://example.com")
            .build()
        retrofit
    }

    viewModel { HomeViewModel (get()) }
//    viewModel { LoginViewModel (get()) }
//    viewModel { HomeViewModel (get()) }
}