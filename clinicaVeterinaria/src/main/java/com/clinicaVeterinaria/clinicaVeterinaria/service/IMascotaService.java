package com.clinicaVeterinaria.clinicaVeterinaria.service;

import com.clinicaVeterinaria.clinicaVeterinaria.model.Mascota;

import java.util.List;

public interface IMascotaService {

    //crearmascota
    public void saveMascota(Mascota masco);

    //traermascotas
    public List<Mascota> traerMascotas();

    //para encontrar una mascota
    public Mascota findMascota(Long id);

    //editarmascotas
    public Mascota editarMascota(Long id,Mascota nuevaMasco);

    //eliminarmascota
    public void deleteMascota(Long id);
}
