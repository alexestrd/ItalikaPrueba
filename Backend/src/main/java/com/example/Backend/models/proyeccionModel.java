package com.example.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "proyeccion")
public class proyeccionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_proyeccion")
    private Long id_proyeccion;

    @Getter @Setter @Column(name = "duracion")
    private int duracion;

    @Getter @Setter @Column(name = "tasa_fija")
    private int tasa_fija;

    @Getter @Setter @Column(name = "mensualidades")
    private int mensualidades;
}
