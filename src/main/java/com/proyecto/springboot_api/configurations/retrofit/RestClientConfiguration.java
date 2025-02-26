package com.proyecto.springboot_api.configurations.retrofit;


import com.proyecto.springboot_api.client.ClientRetrofit;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@RequiredArgsConstructor
public class RestClientConfiguration {

    private final RetrofitConfig retrofitConfig;

    @Bean 
    public ClientRetrofit personasMidClient() throws IOException { //Con esto al hacer la peticion se crea el cliente retrofit para la peticion
        return retrofitConfig.crearClienteApi()
                .create(ClientRetrofit.class); //La clase que indicamos es la interface con las llamadas a nuestra api
    }
}
