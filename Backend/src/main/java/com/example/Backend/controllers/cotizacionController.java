package com.example.Backend.controllers;

import com.example.Backend.dao.cotizacionDao;
import com.example.Backend.models.cotizacionModel;
import com.example.Backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class cotizacionController {


    @Autowired
    private cotizacionDao CotizacionDao;
    @Autowired
    private JWTUtil jwtutil;

    @RequestMapping(value = "api/cotizacion", method = RequestMethod.GET)
    public List<cotizacionModel> getcotizacions(){
        return CotizacionDao.getcotizacions();
    }

    @RequestMapping(value = "api/cotizacion/{id_categoria}", method = RequestMethod.GET)
    public List<cotizacionModel> getcotizacion(@PathVariable Long id_cotizacion){
        List<cotizacionModel> cotizacion = CotizacionDao.getcotizacion(id_cotizacion);
        return cotizacion;
    }

    @RequestMapping(value = "api/cotizacion", method = RequestMethod.POST)
    public void postcotizacion(@RequestBody cotizacionModel cotizacion){
        CotizacionDao.postcotizacion(cotizacion);
    }

    @RequestMapping(value = "api/cotizacion/{id_cotizacion}", method = RequestMethod.DELETE)
    public void deletecotizacion(@PathVariable Long id_cotizacion){
        CotizacionDao.deletecotizacion(id_cotizacion);
    }

    @RequestMapping(value = "api/cotizacion/{id_cotizacion}", method = RequestMethod.PUT)
    public void editcotizacion(@RequestBody cotizacionModel cotizacion, @PathVariable Long id_cotizacion){
        CotizacionDao.editClliente(cotizacion, id_cotizacion);
    }
}
