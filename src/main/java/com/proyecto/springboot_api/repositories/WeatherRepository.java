package com.proyecto.springboot_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot_api.models.entity.ApiWeather;
import com.proyecto.springboot_api.models.entity.ApiWeather.WeatherLocationId;

public interface WeatherRepository extends JpaRepository<ApiWeather, WeatherLocationId> {

    
    
}
