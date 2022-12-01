package com.kospavel.sandbox.network

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

object OkHttpFactory {

    fun getClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    private const val TIMEOUT = 310L

}