package com.kospavel.sandbox.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.POST

// start server: flask --app Server run
interface ServerApi {

    @POST("/test")
    suspend fun testRequest(): Response<ResponseBody>

}