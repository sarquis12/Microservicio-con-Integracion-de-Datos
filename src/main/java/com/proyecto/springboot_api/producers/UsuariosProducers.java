package com.proyecto.springboot_api.producers;

import java.util.List;

import com.proyecto.springboot_api.models.dtos.UsuarioDto;



public interface UsuariosProducers {
    List<UsuarioDto> getUsuarios(Integer cantidad) throws Exception;
}
