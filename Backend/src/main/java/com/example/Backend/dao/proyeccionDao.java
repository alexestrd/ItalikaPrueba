package com.example.Backend.dao;

import com.example.Backend.models.proyeccionModel;

import java.util.List;
import java.util.Map;

public interface proyeccionDao {

    /*Registra una nueva proyeccion*/
    void postproyeccion(proyeccionModel proyeccion);

    /*Obtiene todos los proyeccions*/
    List<proyeccionModel> getproyeccions();

    /*Obtiene un proyeccion*/
    List<proyeccionModel> getproyeccion(Long id_proyeccion);

    /*Elimina un proyeccion*/
    void deleteproyeccion(Long id_proyeccion);

    void editClliente(proyeccionModel proyeccion, Long id_proyeccion);

    Map<String, Object> realizarproyeccion(int precio, int mensualidad);
}
