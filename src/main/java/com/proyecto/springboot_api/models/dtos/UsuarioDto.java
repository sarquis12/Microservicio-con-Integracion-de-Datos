package com.proyecto.springboot_api.models.dtos;

import java.time.LocalDate;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.proyecto.springboot_api.embeddables.Coordenadas;
import com.proyecto.springboot_api.embeddables.Login;



public class UsuarioDto {
    @JsonProperty("gender")
    private String genero;

    @JsonProperty("name")
    private Nombre nombre;

    @JsonProperty("location")
    private Locacion locacion;

    @JsonProperty("email")
    private String email;

    @JsonProperty("login")
    private Login login;

    @JsonProperty("dob")
    private FechaNacimiento fechaNacimiento;

    @JsonProperty("cell")
    private String celular;

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public Nombre getNombre() { return nombre; }
    public void setNombre(Nombre nombre) { this.nombre = nombre; }
    public Locacion getLocacion() { return locacion; }
    public void setLocacion(Locacion locacion) { this.locacion = locacion; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Login getLogin() { return login; }
    public void setLogin(Login login) { this.login = login; }
    public FechaNacimiento getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(FechaNacimiento fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }

    public static class Nombre {
        @JsonProperty("first")
        private String nombre;

        @JsonProperty("last")
        private String apellido;

        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getApellido() { return apellido; }
        public void setApellido(String apellido) { this.apellido = apellido; }
    }

    public static class Locacion {
        @JsonProperty("city")
        private String ciudad;

        @JsonProperty("country")
        private String pais;

        @JsonProperty("coordinates")
        private Coordenadas coordenadas;

        public String getCiudad() { return ciudad; }
        public void setCiudad(String ciudad) { this.ciudad = ciudad; }
        public String getPais() { return pais; }
        public void setPais(String pais) { this.pais = pais; }
        public Coordenadas getCoordenadas() { return coordenadas; }
        public void setCoordenadas(Coordenadas coordenadas) { this.coordenadas = coordenadas; }
    }

    public static class FechaNacimiento {
        @JsonProperty("date")
        private LocalDate fecha;

        public LocalDate getFecha() { return fecha; }
        public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    }
}