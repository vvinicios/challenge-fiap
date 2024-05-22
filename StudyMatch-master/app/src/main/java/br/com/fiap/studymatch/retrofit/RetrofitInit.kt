package br.com.fiap.studymatch.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInit {

    /*TODO Digite a URL da api aqui */
    private val URL = " "

    private val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()

    fun getAPIService(): APIService{
        return retrofit.create(APIService::class.java)
    }

}