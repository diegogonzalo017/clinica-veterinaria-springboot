package com.clinicaVeterinaria.clinicaVeterinaria.service;

import com.clinicaVeterinaria.clinicaVeterinaria.model.Mascota;
import com.clinicaVeterinaria.clinicaVeterinaria.repository.IMascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository mascoRepo;

    @Override
    public void saveMascota(Mascota masco) {

        mascoRepo.save(masco);
    }

    @Override
    public List<Mascota> traerMascotas() {
        List<Mascota> ListaMascotas= mascoRepo.findAll();
        return ListaMascotas;
    }

    @Override
    public Mascota findMascota(Long id) {
        Mascota masco = mascoRepo.findById(id).orElse(null);
        return masco;
    }

    @Override
    public Mascota editarMascota(Long id, Mascota nuevaMasco) {
        Mascota masco = mascoRepo.findById(id).orElse(null);
        masco.setNombre(nuevaMasco.getNombre());
        masco.setEspecie(nuevaMasco.getEspecie());
        masco.setRaza(nuevaMasco.getRaza());
        masco.setColor(nuevaMasco.getColor());
        masco.setDueño(nuevaMasco.getDueño());

        return mascoRepo.save(masco);
    }



    @Override
    public void deleteMascota(Long id) {

        mascoRepo.deleteById(id);
    }
}
