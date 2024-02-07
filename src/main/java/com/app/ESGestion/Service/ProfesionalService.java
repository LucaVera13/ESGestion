package com.app.ESGestion.Service;

import com.app.ESGestion.Model.Profesional;
import com.app.ESGestion.Repository.ProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionalService implements IProfesionalService {


    @Autowired
    private ProfesionalRepository profRepository;

    @Override
    public List<Profesional> getProfesionales() {
        List<Profesional> listaProfesionales = profRepository.findAll();
        return listaProfesionales;
    }

    @Override
    public void saveProfesional(Profesional profesional) {
        profRepository.save(profesional);
    }

    @Override
    public void deleteProfesional(Long id) {
        profRepository.deleteById(id);
    }

    @Override
    public Profesional findProfesional(Long id) {
        Profesional profesional = profRepository.findById(id).orElse(null);
        return profesional;
    }
    @Override
    public void updateProfesional(Long id, String profesion, String nombreCompleto, String matriculaCptba, String matriculaMunicipal, String domicilio, String numTelefono, String email) {
        Profesional existingProfesional = profRepository.findById(id).orElse(null);
        if (existingProfesional != null) {
            if (profesion != null) {
                existingProfesional.setProfesion(profesion);
            }
            if (nombreCompleto != null) {
                existingProfesional.setNombreCompleto(nombreCompleto);
            }
            if (matriculaCptba != null) {
                existingProfesional.setMatriculaCptba(matriculaCptba);
            }
            if (matriculaMunicipal != null) {
                existingProfesional.setMatriculaMunicipal(matriculaMunicipal);
            }
            if (domicilio != null) {
                existingProfesional.setDomicilio(domicilio);
            }
            if (numTelefono != null) {
                existingProfesional.setNumTelefono(numTelefono);
            }
            if (email != null) {
                existingProfesional.setEmail(email);
            }
            profRepository.save(existingProfesional);
        }
    }
}
