package com.example.Backend.dao;

import com.example.Backend.models.clienteModel;

import java.util.List;
public interface clienteDao {

    /*Registra un nuevo cliente*/
    void postCliente(clienteModel cliente);

    /*Obtiene todos los clientes*/
    List<clienteModel> getClientes();

    /*Obtiene un cliente*/
    List<clienteModel> getCliente(Long id_cliente);

    /*Elimina un cliente*/
    void deleteCliente(Long id_cliente);

    void editClliente(clienteModel cliente, Long id_cliente);

}
