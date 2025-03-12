package com.proyecto.springboot_api.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import org.springframework.stereotype.Component;

import com.proyecto.springboot_api.models.dtos.UsuarioDto;
import com.proyecto.springboot_api.models.entity.Usuario;


import java.time.LocalDate;



@Mapper(componentModel = "spring")
@Component
public interface UsuariosMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "fechaNacimiento", source = "fechaNacimiento.fecha")
    @Mapping(target = "nombre", source = "nombre.nombre")
    @Mapping(target = "apellido", source = "nombre.apellido")
    @Mapping(target = "ciudad", source = "locacion.ciudad")
    @Mapping(target = "pais", source = "locacion.pais")
    @Mapping(target = "coordenadas", source = "locacion.coordenadas")
    Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto);

    List<Usuario> usuariosDtoToUsuarios(List<UsuarioDto> usuariosDto);


    // Nueva conversión de Usuario a UsuarioDto
    @Mapping(source = "fechaNacimiento", target = "fechaNacimiento.fecha")
    @Mapping(source = "nombre", target = "nombre.nombre")
    @Mapping(source = "apellido", target = "nombre.apellido")
    @Mapping(source = "ciudad", target = "locacion.ciudad")
    @Mapping(source = "pais", target = "locacion.pais")
    @Mapping(source = "coordenadas", target = "locacion.coordenadas")
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);
    List<UsuarioDto> usuariosToUsuariosDto(List<Usuario> usuarios);


    default UsuarioDto.FechaNacimiento mapFechaNacimiento(LocalDate value) {
        if (value == null) {
            return null;
        }
        UsuarioDto.FechaNacimiento fechaNacimiento = new UsuarioDto.FechaNacimiento();
        fechaNacimiento.setFecha(value);
        return fechaNacimiento;
    }

    default UsuarioDto.Nombre mapNombre(String value) {
        if (value == null) {
            return null;
        }
        UsuarioDto.Nombre nombre = new UsuarioDto.Nombre();
        nombre.setNombre(value);
        return nombre;
    }





}