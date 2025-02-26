package com.proyecto.springboot_api.configurations.retrofit;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Request;
import org.springframework.context.annotation.Configuration;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


@Slf4j
@Configuration
@RequiredArgsConstructor
public class RetrofitConfig {

    public Retrofit crearClienteApi() throws IOException {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY); //Seteamos el nivel de logueo de nuestra peticion

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.interceptors().clear();
        httpClient.connectTimeout(100000, TimeUnit.MILLISECONDS); //Configuracion para timeout
        httpClient.readTimeout(100000, TimeUnit.MILLISECONDS); //Configuracion para timeout
        httpClient.addInterceptor(logging); //Agregamos logging
        httpClient.addInterceptor( chain -> { //Agregamos headers
            Request request = chain.request();
            Request.Builder builder1 = request.newBuilder()
                    .header("Content-Type","application/json");
            Request request1 = builder1.build();
            return chain.proceed(request1);
            });

        return new Retrofit.Builder()
            .baseUrl("https://api.open-meteo.com") //Agregamos nuestra url base
            .addConverterFactory(JacksonConverterFactory.create()) //Agregamos nuestro mapper para construir nuestro objeto Java a partir del JSON de respuesta
            .client(httpClient.build()) //Si no seteamos el http client no vamos a tener un log de la respuesta de retrofit, pero funcionaria igualmente
            .build();
    }
}
