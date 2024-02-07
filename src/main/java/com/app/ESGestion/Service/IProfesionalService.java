package com.app.ESGestion.Service;

import com.app.ESGestion.Model.Profesional;

import java.util.List;

public interface IProfesionalService {
     List<Profesional> getProfesionales();

     void saveProfesional(Profesional profesional);

     void deleteProfesional(Long id);

     Profesional findProfesional(Long id);

    void updateProfesional(Long profesional_id, String profesion, String nombreCompleto, String matriculaCptba, String matriculaMunicipal, String domicilio, String numTelefono, String email);
}
