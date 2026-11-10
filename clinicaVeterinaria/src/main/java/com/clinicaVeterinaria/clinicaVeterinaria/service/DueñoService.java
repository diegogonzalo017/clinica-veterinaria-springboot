package com.clinicaVeterinaria.clinicaVeterinaria.service;

import com.clinicaVeterinaria.clinicaVeterinaria.model.Dueño;
import com.clinicaVeterinaria.clinicaVeterinaria.repository.IDueñoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DueñoService implements IDueñoService {

    @Autowired
    private IDueñoRepository dueñoRepo;

    @Override
    public void crearDueño(Dueño dueño) {
        dueñoRepo.save(dueño);
    }

    @Override
    public List<Dueño>  listaDueños() {
        List<Dueño> listaDueños= dueñoRepo.findAll();
        return listaDueños;
    }

    @Override
    public Dueño findDueño(Long id) {
        Dueño dueño = dueñoRepo.findById(id).orElse(null);
        return dueño;
    }

    @Override
    public void deleteDueño(long id) {
    dueñoRepo.deleteById(id);
    }

    @Override
    public Dueño editarDueño(Long id, Dueño nuevoDueño) {
        Dueño dueño = dueñoRepo.findById(id).orElse(null);
        dueño.setNombre(nuevoDueño.getNombre());
        dueño.setApellido(nuevoDueño.getApellido());
        dueño.setDni(nuevoDueño.getDni());
        dueño.setCelular(nuevoDueño.getCelular());


        return dueñoRepo.save(dueño);
    }
}
