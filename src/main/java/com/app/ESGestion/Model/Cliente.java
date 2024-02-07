package com.app.ESGestion.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCli;
    private String nombreCli;
    private String domicilioCli;
    private String numCli;
    private String emailCli;

    @ManyToOne
    @JoinColumn(name = "idProf")
    private Profesional profesional;

    @OneToMany(mappedBy = "cliente")
    private List<Archivo> archivos = new ArrayList<>();

    public Cliente() {
    }
    public Cliente(String nombreCli, String domicilioCli, String numCli, String emailCli) {
        this.nombreCli = nombreCli;
        this.domicilioCli = domicilioCli;
        this.numCli = numCli;
        this.emailCli = emailCli;
    }

}
