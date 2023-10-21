package com.example.Backend.dao;

import com.example.Backend.models.costoModel;

import java.util.List;

public interface costoDao {

    /*Registra un nuevo costo*/
    void postcosto(costoModel costo);

    /*Obtiene todos los costos*/
    List<costoModel> getcostos();

    /*Obtiene un costo*/
    List<costoModel> getcosto(Long id_costo);

    /*Elimina un costo*/
    void deletecosto(Long id_costo);

    void editClliente(costoModel costo, Long id_costo);
    
}
