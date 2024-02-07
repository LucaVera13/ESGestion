package com.app.ESGestion.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Archivo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombreArchivo;
    private String rutaArchivo;

    @ManyToOne
    @JoinColumn(name = "idProf")
    private Profesional profesional;

    @ManyToOne
    @JoinColumn(name = "idCli")
    private Cliente cliente;

    public Archivo() {
    }

    public Archivo(Long id, String nombreArchivo, String rutaArchivo, Profesional profesional, Cliente cliente) {
        this.id = id;
        this.nombreArchivo = nombreArchivo;
        this.rutaArchivo = rutaArchivo;
        this.profesional = profesional;
        this.cliente = cliente;
    }
}
