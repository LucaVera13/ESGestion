package com.app.ESGestion.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
@Entity
public class Profesional {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String profesion;
    private String nombreCompleto;
    private String matriculaCptba;
    private String matriculaMunicipal;
    private String domicilio;
    private String numTelefono;
    private String email;

    public Profesional() {
    }

    public Profesional(Long id, String profesion, String nombreCompleto, String matriculaCptba,
                       String matriculaMunicipal, String domicilio, String numTelefono, String email) {
        this.id = id;
        this.profesion = profesion;
        this.nombreCompleto = nombreCompleto;
        this.matriculaCptba = matriculaCptba;
        this.matriculaMunicipal = matriculaMunicipal;
        this.domicilio = domicilio;
        this.numTelefono = numTelefono;
        this.email = email;
    }
}
