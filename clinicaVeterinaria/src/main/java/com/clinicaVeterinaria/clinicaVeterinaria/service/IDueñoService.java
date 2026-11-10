package com.clinicaVeterinaria.clinicaVeterinaria.service;

import com.clinicaVeterinaria.clinicaVeterinaria.model.Dueño;

import java.util.List;

public interface IDueñoService {

    //metodoparacrearundueño
    public void crearDueño(Dueño dueño);

    //metodo para traer lista de dueños
    public List<Dueño> listaDueños();

    //metodo para traer un dueño
    public Dueño findDueño(Long id);

    //metodo para eliminar un dueño
    public void deleteDueño(long id);

    //metodo para editar dueño
    public Dueño editarDueño(Long id, Dueño nuevoDueño);
}
