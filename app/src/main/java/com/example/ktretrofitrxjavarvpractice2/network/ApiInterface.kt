package com.example.ktretrofitrxjavarvpractice2.network

import com.example.ktretrofitrxjavarvpractice2.model.Model
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    //https://jsonplaceholder.typicode.com/comments
    @GET ("comments")
    fun getComments() : Call<List<Model.Comment>>

    companion object {
        val BASE_URL = "https://jsonplaceholder.typicode.com/"
        fun getRetrofitInstance() : ApiInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return  retrofit.create(ApiInterface::class.java)

        }

    }

}