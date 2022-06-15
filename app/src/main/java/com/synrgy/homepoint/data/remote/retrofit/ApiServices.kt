package com.synrgy.homepoint.data.remote.retrofit

import com.synrgy.homepoint.data.remote.response.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServices {
    @POST("register")
    fun register(
            @Body regisRequest: RegisterRequest
    ): Call<UserResponse>

    @POST("login")
    fun login(
            @Body userRequest: UserRequest
    ): Call<UserResponse>
}