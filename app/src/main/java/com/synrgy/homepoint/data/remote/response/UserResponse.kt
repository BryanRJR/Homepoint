package com.synrgy.homepoint.data.remote.response

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("data")
    var data: User? = null,

    )

class User {
    @SerializedName("name")
    var name: String? = null

    @SerializedName("token")
    var token: String? = null

}