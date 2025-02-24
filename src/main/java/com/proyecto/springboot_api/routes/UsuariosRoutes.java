package com.proyecto.springboot_api.routes;

import lombok.RequiredArgsConstructor;
import org.apache.camel.Exchange;


import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;




@Component
@RequiredArgsConstructor
public class UsuariosRoutes extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // Manejo de excepciones
        onException(Exception.class)
            .log("Error al generar usuarios: ${exception.message}")
            .handled(true)
            .end();

        from("direct:generar-usuarios")
            .log("Iniciando la generación de usuarios")
            
            // Configuración de la petición HTTP
            .setHeader(Exchange.HTTP_METHOD, constant("GET"))
            .setHeader(Exchange.CONTENT_TYPE, constant("application/json"))
            .setHeader(Exchange.HTTP_QUERY, simple("results=${header.cantidad}"))
            
            // Llamada a la API
            .toD("https://randomuser.me/api")
            .log("Respuesta recibida de la API")
            
            // Procesamiento de la respuesta
            .log("Body de la respuesta: ${body}")
            .log("Headers de la respuesta: ${headers}")
            
            // Finalización de la ruta
            .end();
    } 
}
