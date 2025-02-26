package com.proyecto.springboot_api.client;

import org.springframework.beans.factory.annotation.Autowired;

import com.proyecto.springboot_api.models.responses.ApiWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Body; // Por si queremos pasar un body en un metodo POST
import retrofit2.http.Path; // Para pasar un parametro por Path
import retrofit2.http.Query; //Para pasar un parametro por Query
import retrofit2.http.Header; //Para pasar un parametro por Header

public interface ClientRetrofit {
    
    @GET("/v1/forecast")
    Call<ApiWeatherResponse> getWeather(@Query("latitude") Double latitude, @Query("longitude") Double longitude, @Query("current_weather")String current_weather);
}
