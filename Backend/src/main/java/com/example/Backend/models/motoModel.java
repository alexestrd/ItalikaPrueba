package com.example.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "moto")
public class motoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_moto")
    private Long id_moto;

    @Getter @Setter @Column(name = "Modelo")
    private String modelo;

    @Getter @Setter @Column(name = "version")
    private String version;

    @Getter @Setter @Column(name = "id_costo")
    private int id_costo;
}
