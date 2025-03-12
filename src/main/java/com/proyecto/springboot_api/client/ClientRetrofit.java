package com.proyecto.springboot_api.client;



import com.proyecto.springboot_api.models.responses.ApiWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.http.Query; //Para pasar un parametro por Query


public interface ClientRetrofit {
    
    @GET("/v1/forecast")
    Call<ApiWeatherResponse> getWeather(@Query("latitude") Double latitude, @Query("longitude") Double longitude, @Query("current_weather")String current_weather);
}
