package com.app.ESGestion.Repository;

import com.app.ESGestion.Model.Profesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional,Long> {

}
