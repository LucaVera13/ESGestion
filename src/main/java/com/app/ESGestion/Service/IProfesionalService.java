package com.app.ESGestion.Service;

import com.app.ESGestion.Model.Profesional;

import java.util.List;

public interface IProfesionalService {
    public List<Profesional> getProfesionales();

    public void saveProfesional(Profesional profesional);

    public void deleteProfesional(Long id);

    public Profesional findProfesional(Long id);

    void updateProfesional(Long id, String profesion, String nombreCompleto, String matriculaCptba, String matriculaMunicipal, String domicilio, String numTelefono, String email);
}
