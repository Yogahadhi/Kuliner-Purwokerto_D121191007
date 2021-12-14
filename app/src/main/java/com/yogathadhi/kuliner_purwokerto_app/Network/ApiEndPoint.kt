package com.yogathadhi.kuliner_purwokerto_app.Network

import retrofit2.Call
import retrofit2.http.GET


interface api {

    @GET("api/purwakarta/kuliner")

    fun getDataKuliner(): Call<DataKuliner>
}