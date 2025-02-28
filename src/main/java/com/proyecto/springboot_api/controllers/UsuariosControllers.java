package com.proyecto.springboot_api.controllers;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.springboot_api.models.dtos.UsuarioDto;
import com.proyecto.springboot_api.models.entity.Usuario;

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

    @Operation(summary = "Insertar usuario", description = "Inserta un usuario")
    @PostMapping("/InsertarUsuario")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario InsertarUsuario(@RequestBody @Parameter(name = "usuario", description = "Objeto persona") final Usuario usuario) throws Exception {
        log.info("Insertando usuario: ", usuario);
        return usuariosServices.InsertUsuario(usuario);
    }
    

    
    @Operation(summary = "Buscar usuario por id", description = "Busca un usuario por id")
    @GetMapping("/BuscarUsuarioPorId/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto BuscarUsuarioPorId(@PathVariable(name = "id" ) @Parameter(name = "id", description = "ID de la persona a buscar")
    final Long id) throws Exception {
        log.info("Buscando usuario: ", id);
        return usuariosServices.GetUsuario(id);
    }

    @Operation(summary = "Actualizar usuario", description = "Actualiza un usuario")
    @PostMapping("/ActualizarUsuario")
    @ResponseStatus(HttpStatus.OK)
    public Usuario ActualizarUsuario(@RequestBody @Parameter(name = "usuario", description = "Objeto persona") final Usuario usuario) throws Exception {
        log.info("Actualizando usuario: ", usuario);
        return usuariosServices.UpdateUsuario(usuario);
    }


    @Operation(summary = "Actulizar Correo", description = "Actualiza el correo de un usuario")
    @PatchMapping("/ActualizarCorreo/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Void ActualizarCorreo(@PathVariable(name = "id" ) @Parameter(name = "id", description = "ID de la persona a buscar") final Long id, 
                                @RequestBody @Parameter(name = "correo", description = "Correo de la persona") final String correo) throws Exception {
        log.info("Actualizando correo: ", id);
        usuariosServices.UpdateCorreo(id, correo);
        return null;
    }





}   
