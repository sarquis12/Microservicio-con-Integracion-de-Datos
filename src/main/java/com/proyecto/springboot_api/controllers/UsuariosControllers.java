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
import com.proyecto.springboot_api.services.UsuariosServices;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/Personas")
@Slf4j
@Tag(name = "Personas", description = "Operaciones relacionadas con las personas")
@Validated
@RequiredArgsConstructor
public class UsuariosControllers {
    private final UsuariosServices usuariosServices;

    @Operation(summary = "Generar personas aleatorias", description = "Genera personas aleatorias en base a la cantidad solicitada y guardarlas en DB")
    @PostMapping("/GenerarPersonas/{cantidad}")
    @ResponseStatus(HttpStatus.OK)
    public List<UsuarioDto> GenerarPersonas( @PathVariable(name = "cantidad" ) @Parameter(name = "cantidad", description = "DNI de la persona a buscar")
    final Integer cantidad) throws Exception {
        log.info("Generando personas aleatorias");
        return usuariosServices.GenerarUsuarios(cantidad);
    }

}   
