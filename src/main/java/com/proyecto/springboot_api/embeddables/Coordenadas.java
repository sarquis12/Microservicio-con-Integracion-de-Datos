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
public class Coordenadas {
    @Schema(description = "Latitud de la ubicación", example = "40.4165")
    @JsonAlias({"latitude", "lat"}) // Acepta "latitude" o "lat" en el JSON
    @JsonProperty("latitud") // Nombre del campo en la clase
    private double latitud;

    @Schema(description = "Longitud de la ubicación", example = "-3.70256")
    @JsonAlias({"longitude", "long"}) // Acepta "longitude" o "long" en el JSON
    @JsonProperty("longitud") // Nombre del campo en la clase
    private double longitud;
}
