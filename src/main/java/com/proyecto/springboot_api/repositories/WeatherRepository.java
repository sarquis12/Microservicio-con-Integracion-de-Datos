package com.proyecto.springboot_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.springboot_api.models.entity.ApiWeather;

public interface WeatherRepository extends JpaRepository<ApiWeather, Long> {

    
    
}
