package com.kospavel.sandbox.di

import com.kospavel.sandbox.network.ServerApi
import com.kospavel.sandbox.network.OkHttpFactory
import com.kospavel.sandbox.network.RetrofitFactory
import com.kospavel.sandbox.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    viewModel { MainViewModel(get()) }
    single { OkHttpFactory.getClient() }
    single { RetrofitFactory.getRetrofit(get()) }
    single { get<Retrofit>().create(ServerApi::class.java) }

}