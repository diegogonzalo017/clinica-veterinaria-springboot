package com.clinicaVeterinaria.clinicaVeterinaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Dueño {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Long id_dueño;
   private String dni;
   private String nombre;
   private String apellido;
   private String celular;



    public Dueño() {
    }

    public Dueño(String dni, Long id_dueño, String nombre, String apellido, String celular, Mascota mascota) {
        this.dni = dni;
        this.id_dueño = id_dueño;
        this.nombre = nombre;
        this.apellido = apellido;
        this.celular = celular;

    }
}
