package com.proyecto.springboot_api.producers.Impl;


import java.util.List;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.Exchange;

import org.springframework.stereotype.Component;
import com.proyecto.springboot_api.models.dtos.UsuarioDto;
import com.proyecto.springboot_api.producers.UsuariosProducers;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.springboot_api.models.ApiUserResponse;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UsuariosProducersImpl implements UsuariosProducers {
    
    //private final ObjectMapper objectMapper;
    private final ProducerTemplate producerTemplate;

    private final ObjectMapper objectMapper;

    @Override
    public List<UsuarioDto> getUsuarios(Integer cantidad) throws Exception {
        
        // Invocar la ruta Camel
        Exchange exchange = producerTemplate.request("direct:generar-usuarios", ex -> {
            ex.getIn().setHeader("cantidad", cantidad);
        });

        // Manejar errores
        if (exchange.getException() != null) {
            throw exchange.getException();
        }

        // Obtener el body de la respuesta
        String responseBody = exchange.getMessage().getBody(String.class);

        // Mapear el JSON a la clase ApiResponse
        ApiUserResponse apiResponse = objectMapper.readValue(responseBody, ApiUserResponse.class);

        // Retornar la lista de usuarios
        return apiResponse.getResultados();

        
    }
}