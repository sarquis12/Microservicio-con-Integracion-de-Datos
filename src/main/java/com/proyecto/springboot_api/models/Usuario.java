package com.proyecto.springboot_api.models;

import com.proyecto.springboot_api.embeddables.Coordenadas;
import com.proyecto.springboot_api.embeddables.Login;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Embedded;


import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String genero;
    private String nombre;
    private String apellido;
    private String ciudad;
    private String pais;

    @Embedded
    private Coordenadas coordenadas;

    @Embedded
    private Login login;

    private String email;
    private LocalDate fechaNacimiento;
    private String celular;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }
    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }
    public Coordenadas getCoordenadas() { return coordenadas; }
    public void setCoordenadas(Coordenadas coordenadas) { this.coordenadas = coordenadas; }
    public Login getLogin() { return login; }
    public void setLogin(Login login) { this.login = login; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }
    public String getCelular() { return celular; }
    public void setCelular(String celular) { this.celular = celular; }
}
