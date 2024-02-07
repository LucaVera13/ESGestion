package com.app.ESGestion.Controller;

import com.app.ESGestion.Model.Profesional;
import com.app.ESGestion.Service.IProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfesionalController {
    @Autowired
    private IProfesionalService interProf;

    @GetMapping("/profesional/traer")
    public List<Profesional> getProfesionales(){
        return interProf.getProfesionales();
    }

    @PostMapping("/profesional/crear")
    public String createProfesional(@RequestBody Profesional prof){
        interProf.saveProfesional(prof);
        return "Profesional creado con exito!";
    }
    @DeleteMapping("/profesional/borrar/{id}")
    public String deleteProfesional(@PathVariable Long id){
        interProf.deleteProfesional(id);
        return "Se borro al profesional correctamente !!";
    }
    @PutMapping("/profesional/editar/{id}")
    public Profesional editProfesional(@PathVariable Long id,
                                       @RequestParam(required = false,name = "profesion") String profesion,
                                       @RequestParam(required = false,name = "nombreCompleto") String nombreCompleto,
                                       @RequestParam(required = false,name = "matriculaCptba") String matriculaCptba,
                                       @RequestParam(required = false,name = "matriculaMunicipal") String matriculaMunicipal,
                                       @RequestParam(required = false,name = "domicilio") String domicilio,
                                       @RequestParam(required = false,name = "numTelefono") String numTelefono,
                                       @RequestParam(required = false,name = "email") String email) {

        interProf.updateProfesional(id, profesion, nombreCompleto, matriculaCptba, matriculaMunicipal ,domicilio, numTelefono,email);

        Profesional prof = interProf.findProfesional(id);

        return prof;
    }

}
