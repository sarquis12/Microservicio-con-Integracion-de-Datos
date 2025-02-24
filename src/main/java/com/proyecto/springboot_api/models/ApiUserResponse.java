package com.proyecto.springboot_api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import com.proyecto.springboot_api.models.dtos.UsuarioDto;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ApiUserResponse {

    @JsonProperty("results")
    private List<UsuarioDto> resultados;
}
