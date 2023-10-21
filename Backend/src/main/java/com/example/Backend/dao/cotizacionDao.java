package com.example.Backend.dao;

import com.example.Backend.models.cotizacionModel;

import java.util.List;

public interface cotizacionDao {

    /*Registra un nuevo cotizacion*/
    void postcotizacion(cotizacionModel cotizacion);

    /*Obtiene todos los cotizacions*/
    List<cotizacionModel> getcotizacions();

    /*Obtiene un cotizacion*/
    List<cotizacionModel> getcotizacion(Long id_cotizacion);

    /*Elimina un cotizacion*/
    void deletecotizacion(Long id_cotizacion);

    void editClliente(cotizacionModel cotizacion, Long id_cotizacion);
}
