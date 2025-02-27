package com.proyecto.springboot_api.services.Impl;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.proyecto.springboot_api.producers.UsuariosProducers;
import com.proyecto.springboot_api.repositories.UsuariosRepository;
import com.proyecto.springboot_api.repositories.WeatherRepository;
import com.proyecto.springboot_api.client.ClientRetrofit;
import com.proyecto.springboot_api.mapper.UsuariosMapper;
import com.proyecto.springboot_api.mapper.WeatherMapper;
import com.proyecto.springboot_api.models.dtos.UsuarioDto;
import com.proyecto.springboot_api.models.entity.ApiWeather;
import com.proyecto.springboot_api.models.entity.Usuario;
import com.proyecto.springboot_api.models.responses.ApiWeatherResponse;
import com.proyecto.springboot_api.services.UsuariosServices;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@Slf4j
@RequiredArgsConstructor
public class UsuariosServicesImpl implements UsuariosServices {

    private static final Logger logger = LoggerFactory.getLogger(UsuariosServicesImpl.class);
    
   
    private final UsuariosMapper usuariosMapper;
    private final WeatherMapper weatherMapper;

  
    private final ClientRetrofit clientRetrofit;

   
    private final UsuariosRepository usuariosRepository;
    private final WeatherRepository weatherRepository;

 
    private final UsuariosProducers usuariosProducers;

    @Override
    public List<UsuarioDto> GenerarUsuarios(Integer cantidad) throws Exception {
        List<UsuarioDto> usuarios = usuariosProducers.getUsuarios(cantidad);
        if (usuarios == null) {
            throw new Exception("No se pudieron obtener los usuarios");
        }

        for (UsuarioDto usuario : usuarios) {
            try {
                logger.info("Llamando a api clima: ");
                Response<ApiWeatherResponse> response = clientRetrofit.getWeather(usuario.getLocacion().getCoordenadas().getLatitud(), usuario.getLocacion().getCoordenadas().getLongitud(),"true").execute();
                if (response.isSuccessful()) {
                    ApiWeatherResponse weatherData = response.body();
                    logger.info("Respuesta obtenida de la peticion: " + weatherData);
                    ApiWeather apiWeather = weatherMapper.toEntity(weatherData);
                    try {
                        weatherRepository.save(apiWeather);
                    } catch (Exception e) {
                        logger.error("Error al guardar el clima", e);
                    }
                } else {
                    logger.error("Error en la respuesta: " + response.code());
                }
            } catch (Exception e) {
                logger.error("Error al llamar a la api de clima", e);
            }
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

    @Override
    public UsuarioDto GetUsuario(Long id) throws Exception {
        
        Usuario usuario = usuariosRepository.findById(id).orElse(null);
        
        if (usuario == null) {
            throw new Exception("No se encontro el usuario");
        }
        return usuariosMapper.usuarioToUsuarioDto(usuario);
    }
}