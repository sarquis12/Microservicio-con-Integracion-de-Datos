package com.proyecto.springboot_api.services.Impl;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.proyecto.springboot_api.producers.UsuariosProducers;
import com.proyecto.springboot_api.repositories.UsuariosRepository;
import com.proyecto.springboot_api.mapper.UsuariosMapper;
import com.proyecto.springboot_api.models.dtos.UsuarioDto;
import com.proyecto.springboot_api.models.Usuario;
import com.proyecto.springboot_api.services.UsuariosServices;

import jakarta.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class UsuariosServicesImpl implements UsuariosServices {

    private static final Logger logger = LoggerFactory.getLogger(UsuariosServicesImpl.class);
    
    UsuariosMapper usuariosMapper = UsuariosMapper.INSTANCE;

    @Autowired
    UsuariosRepository usuariosRepository;

    @Autowired
    UsuariosProducers usuariosProducers;

    @Override
    public List<UsuarioDto> GenerarUsuarios(Integer cantidad) throws Exception {
        List<UsuarioDto> usuarios = usuariosProducers.getUsuarios(cantidad);
        if (usuarios == null) {
            throw new Exception("No se pudieron obtener los usuarios");
        }

        

        try {
            usuariosRepository.saveAll(usuariosMapper.usuariosDtoToUsuarios(usuarios));
        } catch (DataIntegrityViolationException e) {
            logger.error("Error de integridad de datos al guardar usuarios", e);
            throw new Exception("No se pudieron guardar los usuarios debido a un error de integridad de datos", e);
        } catch (Exception e) {
            List<Usuario> usuariose = usuariosMapper.usuariosDtoToUsuarios(usuarios);
            System.out.println(usuariose.get(0).getId());
            System.out.println(usuariose.get(0).getNombre());
            System.out.println(usuariose.get(0).getApellido());
            System.out.println(usuariose.get(0).getFechaNacimiento());
            System.out.println(usuariose.get(0).getCiudad());
            System.out.println(usuariose.get(0).getPais());
            System.out.println(usuariose.get(0).getCoordenadas());

            logger.error("Error inesperado al guardar usuarios", e);
            throw new Exception("No se pudieron guardar los usuarios", e);
        }
        

        return usuarios;

    }
}