package com.clinicaVeterinaria.clinicaVeterinaria.controller;

import com.clinicaVeterinaria.clinicaVeterinaria.model.Mascota;

import com.clinicaVeterinaria.clinicaVeterinaria.service.IMascotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MascotaController {

    @Autowired
    private IMascotaService mascoServ;

    //endpoint para obtener todas las mascotas
    @GetMapping("/traer/mascotas")
    public List<Mascota> listaMascotas(){
        return mascoServ.traerMascotas();
    }

    //endpoint para crear mascota
    @PostMapping("/crear/mascota")
    public void saveMascota(@RequestBody Mascota masco) {
        mascoServ.saveMascota(masco);
    }
    //endpoint para buscar una mascota
        @GetMapping("/traer/mascota/{id_mascota}")
        public Mascota findMascota (@PathVariable Long id_mascota){
        return mascoServ.findMascota(id_mascota);
    }
    //endpoint para elimianr una mascota
    @DeleteMapping("/eliminar/mascota/{id_mascota}")
    public void deleteMascota(@PathVariable Long id_mascota) {
        mascoServ.deleteMascota(id_mascota);
    }
    @PutMapping("/editar/mascota/{id_mascota}")
    public Mascota editMascota(@PathVariable Long id_mascota, @RequestBody Mascota nuevaMasco){
     Mascota masco =  mascoServ.findMascota(id_mascota);
    masco.setNombre(nuevaMasco.getNombre());
    masco.setEspecie(nuevaMasco.getEspecie());
    masco.setRaza(nuevaMasco.getRaza());
    masco.setColor(nuevaMasco.getColor());
    masco.setDueño(nuevaMasco.getDueño());

     mascoServ.saveMascota(masco);
     return masco;

}


}