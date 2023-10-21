package com.example.Backend.dao;

import com.example.Backend.models.proyeccionModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class proyeccionDaoImp implements proyeccionDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void postproyeccion(proyeccionModel proyeccion) {
        entityManager.merge(proyeccion);
    }

    @Override
    public List<proyeccionModel> getproyeccions() {
        String query = "FROM proyeccionModel";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<proyeccionModel> getproyeccion(Long id_proyeccion) {
        String idconverter = Long.toString(id_proyeccion);
        String query = "FROM proyeccionModel WHERE id_proyeccion = :id_proyeccion";
        List<proyeccionModel> list = entityManager.createQuery(query)
                .setParameter("id_proyeccion", idconverter)
                .getResultList();
        return list;
    }

    @Override
    public void deleteproyeccion(Long id_proyeccion) {
        proyeccionModel proyeccion = entityManager.find(proyeccionModel.class, id_proyeccion);
        entityManager.remove(proyeccion);
    }

    @Override
    public void editClliente(proyeccionModel proyeccion, Long id_proyeccion) {
        proyeccionModel proyeccionBuscado = entityManager.find(proyeccionModel.class, id_proyeccion);
        proyeccionBuscado = proyeccion;
        entityManager.merge(proyeccionBuscado);
    }
}
