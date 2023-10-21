package com.example.Backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "costo")
public class costoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_costo")
    private Long id_costo;

    @Getter @Setter @Column(name = "precio_iva")
    private int precio_iva;

    @Getter @Setter @Column(name = "precio")
    private int precio;

    @Getter @Setter @Column(name = "gastos_administrativos")
    private int gastos_administrativos;

    @Getter @Setter @Column(name = "costo_accesorios")
    private int costos_accesorios;

    @Getter @Setter @Column(name = "seguro_vehiculo")
    private int seguro;
}
