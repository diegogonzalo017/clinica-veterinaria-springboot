package com.clinicaVeterinaria.clinicaVeterinaria.controller;

import com.clinicaVeterinaria.clinicaVeterinaria.model.Dueño;
import com.clinicaVeterinaria.clinicaVeterinaria.service.IDueñoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DueñoController {

    @Autowired
    private IDueñoService dueñoServ;

    @GetMapping("/traer/dueños")
    public List<Dueño>getDueños(){
        return dueñoServ.listaDueños();

    }

    @PostMapping("/crear/dueño")
    public void crearDueño(@RequestBody Dueño dueño){

        dueñoServ.crearDueño(dueño);
    }

    @GetMapping("/traer/dueño/{id_dueño}")
    public Dueño getDueño(@PathVariable Long id_dueño) {
        return dueñoServ.findDueño(id_dueño);
    }
    @DeleteMapping("/eliminar/dueño/{id_dueño}")
    public void deleteDueño(@PathVariable Long id_dueño){

        dueñoServ.deleteDueño(id_dueño);

        }

    @PutMapping("/editar/dueño/{id_dueño}")
    public Dueño editarDueño(@PathVariable Long id_dueño, @RequestBody Dueño nuevoDueño){
        Dueño dueño = dueñoServ.findDueño(id_dueño);
        dueño.setNombre(nuevoDueño.getNombre());
        dueño.setApellido(nuevoDueño.getApellido());
        dueño.setDni(nuevoDueño.getDni());
        dueño.setCelular(nuevoDueño.getCelular());


         dueñoServ.crearDueño( dueño);
         return dueño;
    }


    }



