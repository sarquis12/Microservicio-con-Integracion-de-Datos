package com.proyecto.springboot_api.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.proyecto.springboot_api.models.responses.ApiWeatherResponse;
import com.proyecto.springboot_api.models.entity.ApiWeather;

@Mapper(componentModel = "spring")
@Component
public interface WeatherMapper {
    
    
    @Mapping(target = "coordenadas.latitude", source = "latitude")
    @Mapping(target = "coordenadas.longitude", source = "longitude")
    @Mapping(target = "currentWeather", source = "currentWeather")
    @Mapping(target = "currentWeatherUnits", source = "currentWeatherUnits")
    ApiWeather toEntity(ApiWeatherResponse apiWeatherResponse);
}