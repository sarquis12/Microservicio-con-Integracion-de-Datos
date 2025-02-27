package com.proyecto.springboot_api.services.Impl;


import org.springframework.stereotype.Service;

import com.proyecto.springboot_api.repositories.WeatherRepository;
import com.proyecto.springboot_api.models.entity.ApiWeather.WeatherLocationId;

import com.proyecto.springboot_api.mapper.WeatherMapper;
import com.proyecto.springboot_api.models.entity.ApiWeather;

import com.proyecto.springboot_api.services.WeatherServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@Slf4j
@RequiredArgsConstructor
public class WeatherServicesImpl implements WeatherServices {
    private final WeatherRepository weatherRepository;
    

    @Override
    public ApiWeather GetWeatherData(Double latitud, Double longitud) throws Exception {
        WeatherLocationId coordenadas = new WeatherLocationId();
        coordenadas.setLatitude(latitud);
        coordenadas.setLongitude(longitud);
        return weatherRepository.findById(coordenadas).orElseThrow(() -> new Exception("No se encontraron datos"));
    }
    
}
