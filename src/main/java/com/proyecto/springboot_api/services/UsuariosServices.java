package com.proyecto.springboot_api.services;

import java.util.List;

import com.proyecto.springboot_api.models.dtos.UsuarioDto;
import com.proyecto.springboot_api.models.entity.Usuario;

public interface UsuariosServices {

    List<UsuarioDto> GenerarUsuarios(Integer cantidad) throws Exception ;

    UsuarioDto GetUsuario(Long id) throws Exception;

    Usuario UpdateUsuario(Usuario usuario) throws Exception;


}
