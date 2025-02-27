package com.proyecto.springboot_api.services;

import java.util.List;

import com.proyecto.springboot_api.models.dtos.UsuarioDto;

public interface UsuariosServices {

    List<UsuarioDto> GenerarUsuarios(Integer cantidad) throws Exception ;

    UsuarioDto GetUsuario(Long id) throws Exception;
}
