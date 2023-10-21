package com.example.Backend.controllers;

import com.example.Backend.dao.motoDao;
import com.example.Backend.models.motoModel;
import com.example.Backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class motoController {

    @Autowired
    private motoDao MotoDao;
    @Autowired
    private JWTUtil jwtutil;

    @RequestMapping(value = "api/moto", method = RequestMethod.GET)
    public List<motoModel> getmotos(){
        return MotoDao.getmotos();
    }

    @RequestMapping(value = "api/moto/{id_categoria}", method = RequestMethod.GET)
    public List<motoModel> getmoto(@PathVariable Long id_moto){
        List<motoModel> moto = MotoDao.getmoto(id_moto);
        return moto;
    }

    @RequestMapping(value = "api/moto", method = RequestMethod.POST)
    public void postmoto(@RequestBody motoModel moto){
        MotoDao.postmoto(moto);
    }

    @RequestMapping(value = "api/moto/{id_moto}", method = RequestMethod.DELETE)
    public void deletemoto(@PathVariable Long id_moto){
        MotoDao.deletemoto(id_moto);
    }

    @RequestMapping(value = "api/moto/{id_moto}", method = RequestMethod.PUT)
    public void editmoto(@RequestBody motoModel moto, @PathVariable Long id_moto){
        MotoDao.editClliente(moto, id_moto);
    }
}
