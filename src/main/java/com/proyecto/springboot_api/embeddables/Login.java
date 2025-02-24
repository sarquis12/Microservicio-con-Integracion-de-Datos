package com.proyecto.springboot_api.embeddables;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Embeddable;

import lombok.Builder;
import lombok.Data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Data
@NoArgsConstructor
public class Login {

    @Schema(description = "Nombre de usuario", example = "juanperez")
    @JsonAlias({"username", "user"})
    @JsonProperty("usuario")
    private String username;

    @Schema(description = "Contraseña de usuario", example = "123456")
    @JsonAlias({"password", "pass"})
    @JsonProperty("password")
    private String password;
}
