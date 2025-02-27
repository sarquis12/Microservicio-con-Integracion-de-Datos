package com.proyecto.springboot_api.controllers;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.springboot_api.models.dtos.UsuarioDto;
import com.proyecto.springboot_api.models.entity.ApiWeather;
import com.proyecto.springboot_api.services.UsuariosServices;
import com.proyecto.springboot_api.services.WeatherServices;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/Clima")
@Slf4j
@Tag(name = "Clima", description = "Operaciones relacionadas con el clima")
@Validated
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherServices weatherService;
    @Operation(summary = "Buscar clima por Longitud y Latitud", description = "Busca Datos de clima por Longitud y Latitud")
    @GetMapping("/GetDatosClima")
    @ResponseStatus(HttpStatus.OK)
    public ApiWeather BuscarUsuarioPorId(@RequestParam(name = "Longitud") @Parameter(name = "Longitud") final Double Longitud,
                                        @RequestParam(name = "Latitud") @Parameter(name = "Latitud") final Double Latitud   
                                    ) throws Exception {
        log.info("Latitud: ", Latitud);
        log.info("Longitud: ", Longitud);
        return weatherService.GetWeatherData(Latitud, Longitud);
    }
    
}
