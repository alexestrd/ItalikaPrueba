package com.example.Backend.controllers;

import com.example.Backend.dao.proyeccionDao;
import com.example.Backend.models.proyeccionModel;
import com.example.Backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class proyeccionCrontroller {

    @Autowired
    private proyeccionDao ProyeccionDao;
    @Autowired
    private JWTUtil jwtutil;

    @RequestMapping(value = "api/proyeccion", method = RequestMethod.GET)
    public List<proyeccionModel> getproyeccions(){
        return ProyeccionDao.getproyeccions();
    }

    @RequestMapping(value = "api/proyeccion/{id_categoria}", method = RequestMethod.GET)
    public List<proyeccionModel> getproyeccion(@PathVariable Long id_proyeccion){
        List<proyeccionModel> proyeccion = ProyeccionDao.getproyeccion(id_proyeccion);
        return proyeccion;
    }

    @RequestMapping(value = "api/proyeccion", method = RequestMethod.POST)
    public void postproyeccion(@RequestBody proyeccionModel proyeccion){
        ProyeccionDao.postproyeccion(proyeccion);
    }

    @RequestMapping(value = "api/proyeccion/{id_proyeccion}", method = RequestMethod.DELETE)
    public void deleteproyeccion(@PathVariable Long id_proyeccion){
        ProyeccionDao.deleteproyeccion(id_proyeccion);
    }

    @RequestMapping(value = "api/proyeccion/{id_proyeccion}", method = RequestMethod.PUT)
    public void editproyeccion(@RequestBody proyeccionModel proyeccion, @PathVariable Long id_proyeccion){
        ProyeccionDao.editClliente(proyeccion, id_proyeccion);
    }
    @RequestMapping(value = "api/proyeccion/realizar", method = RequestMethod.POST)
    public Map<String, Object> realizarproyeccion(@RequestBody Map<String, Object> datos) {
        int precio = Integer.parseInt(datos.get("precio").toString());
        int mensualidad = (int) datos.get("mensualidades");
        return ProyeccionDao.realizarproyeccion(precio, mensualidad);
    }

}
