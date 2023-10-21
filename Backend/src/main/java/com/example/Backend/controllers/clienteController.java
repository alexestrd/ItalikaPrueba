package com.example.Backend.controllers;

import com.example.Backend.dao.clienteDao;
import com.example.Backend.models.clienteModel;
import com.example.Backend.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class clienteController {

    @Autowired
    private clienteDao ClienteDao;
    @Autowired
    private JWTUtil jwtutil;

    @RequestMapping(value = "api/cliente", method = RequestMethod.GET)
    public List<clienteModel> getClientes(){
        return ClienteDao.getClientes();
    }

    @RequestMapping(value = "api/cliente/{id_categoria}", method = RequestMethod.GET)
    public List<clienteModel> getCliente(@PathVariable Long id_cliente){
        List<clienteModel> cliente = ClienteDao.getCliente(id_cliente);
        return cliente;
    }

    @RequestMapping(value = "api/cliente", method = RequestMethod.POST)
    public void postCliente(@RequestBody clienteModel cliente){
        ClienteDao.postCliente(cliente);
    }

    @RequestMapping(value = "api/cliente/{id_cliente}", method = RequestMethod.DELETE)
    public void deleteCliente(@PathVariable Long id_cliente){
        ClienteDao.deleteCliente(id_cliente);
    }

    @RequestMapping(value = "api/cliente/{id_cliente}", method = RequestMethod.PUT)
    public void editCliente(@RequestBody clienteModel cliente, @PathVariable Long id_cliente){
        ClienteDao.editClliente(cliente, id_cliente);
    }
}
