package com.app.ESGestion.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Profesional {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idProf;
    private String profesion;
    private String nombreCompleto;
    private String matriculaCptba;
    private String matriculaMunicipal;
    private String domicilio;
    private String numTelefono;
    private String email;

    @OneToMany(mappedBy = "profesional")
    private List<Cliente> clientes = new ArrayList<>();

    @OneToMany(mappedBy = "profesional")
    private List<Archivo> archivos = new ArrayList<>();


    public Profesional() {
    }

    public Profesional(Long id, String profesion, String nombreCompleto, String matriculaCptba,
                       String matriculaMunicipal, String domicilio, String numTelefono, String email) {
        this.idProf = id;
        this.profesion = profesion;
        this.nombreCompleto = nombreCompleto;
        this.matriculaCptba = matriculaCptba;
        this.matriculaMunicipal = matriculaMunicipal;
        this.domicilio = domicilio;
        this.numTelefono = numTelefono;
        this.email = email;
    }

}
