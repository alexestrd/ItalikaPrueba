package com.example.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cotizacion")
public class cotizacionModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_cotizacion")
    private Long id_cotizacion;

    @Getter @Setter @Column(name = "id_cliente")
    private int id_cliente;

    @Getter @Setter @Column(name = "id_moto")
    private int id_moto;

    @Getter @Setter @Column(name = "id_costo")
    private int id_costo;

    @Getter @Setter @Column(name = "id_proyeccion")
    private int id_proyeccion;
}
