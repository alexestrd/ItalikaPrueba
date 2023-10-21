package com.example.Backend.controllers;

import com.example.Backend.dao.costoDao;
import com.example.Backend.models.costoModel;
import com.example.Backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class costoController {

    @Autowired
    private costoDao CostoDao;
    @Autowired
    private JWTUtil jwtutil;

    @RequestMapping(value = "api/costo", method = RequestMethod.GET)
    public List<costoModel> getcostos(){
        return CostoDao.getcostos();
    }

    @RequestMapping(value = "api/costo/{id_categoria}", method = RequestMethod.GET)
    public List<costoModel> getcosto(@PathVariable Long id_costo){
        List<costoModel> costo = CostoDao.getcosto(id_costo);
        return costo;
    }

    @RequestMapping(value = "api/costo", method = RequestMethod.POST)
    public void postcosto(@RequestBody costoModel costo){
        CostoDao.postcosto(costo);
    }

    @RequestMapping(value = "api/costo/{id_costo}", method = RequestMethod.DELETE)
    public void deletecosto(@PathVariable Long id_costo){
        CostoDao.deletecosto(id_costo);
    }

    @RequestMapping(value = "api/costo/{id_costo}", method = RequestMethod.PUT)
    public void editcosto(@RequestBody costoModel costo, @PathVariable Long id_costo){
        CostoDao.editClliente(costo, id_costo);
    }
}
