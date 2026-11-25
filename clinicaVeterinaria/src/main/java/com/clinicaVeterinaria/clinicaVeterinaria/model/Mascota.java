package com.clinicaVeterinaria.clinicaVeterinaria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Mascota {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_mascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;

    @ManyToOne
    @JoinColumn(name = "id_dueño")
    private Dueño dueño;

    public Mascota() {
    }

    public Mascota(String nombre, Long id_mascota, String especie, String raza, String color, Dueño dueño) {
        this.nombre = nombre;
        this.id_mascota = id_mascota;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.dueño = dueño;
    }
}
