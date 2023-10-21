package com.example.Backend.controllers;

import com.example.Backend.dao.proyeccionDao;
import com.example.Backend.models.proyeccionModel;
import com.example.Backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
