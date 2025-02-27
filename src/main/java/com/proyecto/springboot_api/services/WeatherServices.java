package com.proyecto.springboot_api.services;

import com.proyecto.springboot_api.models.entity.ApiWeather;

public interface WeatherServices {
    public ApiWeather GetWeatherData(Double latitud, Double longitud) throws Exception;
}
