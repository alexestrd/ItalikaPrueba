package com.example.Backend.dao;

import com.example.Backend.models.clienteModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class clienteDaoImp implements clienteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void postCliente(clienteModel cliente) {
        entityManager.merge(cliente);
    }

    @Override
    public List<clienteModel> getClientes() {
        String query = "FROM clienteModel";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<clienteModel> getCliente(Long id_cliente) {
        String idconverter = Long.toString(id_cliente);
        String query = "FROM clienteModel WHERE id_cliente = :id_cliente";
        List<clienteModel> list = entityManager.createQuery(query)
                .setParameter("id_cliente", idconverter)
                .getResultList();
        return list;
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteModel cliente = entityManager.find(clienteModel.class, id_cliente);
        entityManager.remove(cliente);
    }

    @Override
    public void editClliente(clienteModel cliente, Long id_cliente) {
        clienteModel clienteBuscado = entityManager.find(clienteModel.class, id_cliente);
        clienteBuscado = cliente;
        entityManager.merge(clienteBuscado);
    }
}
