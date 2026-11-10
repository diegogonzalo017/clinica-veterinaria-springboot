package com.clinicaVeterinaria.clinicaVeterinaria.repository;

import com.clinicaVeterinaria.clinicaVeterinaria.model.Dueño;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDueñoRepository extends JpaRepository<Dueño, Long> {



}
