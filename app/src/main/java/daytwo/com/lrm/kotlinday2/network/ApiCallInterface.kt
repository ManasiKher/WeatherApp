package daytwo.com.lrm.kotlinday2.network

import daytwo.com.lrm.kotlinday2.network.response.DataResponse
import daytwo.com.lrm.kotlinday2.network.response.MainWeatherResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

/**
 * Created by manasi on 5/2/18.
 */
//https://api.darksky.net/forecast/683447a9451d48fa77948f968e4ecff0/18.5204,73.8567
interface ApiCallInterface {

    @GET("forecast/683447a9451d48fa77948f968e4ecff0/18.5204,73.8567")
    fun getData() : Call<DataResponse>


    companion object Factory {
        fun create(): ApiCallInterface {
            val retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://api.darksky.net/")
                    .build()
            return retrofit.create(ApiCallInterface::class.java);
        }
    }
}