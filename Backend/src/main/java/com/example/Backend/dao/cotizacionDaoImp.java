package com.example.Backend.dao;

import com.example.Backend.models.cotizacionModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class cotizacionDaoImp implements  cotizacionDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void postcotizacion(cotizacionModel cotizacion) {
        entityManager.merge(cotizacion);
    }

    @Override
    public List<cotizacionModel> getcotizacions() {
        String query = "FROM cotizacionModel";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<cotizacionModel> getcotizacion(Long id_cotizacion) {
        String idconverter = Long.toString(id_cotizacion);
        String query = "FROM cotizacionModel WHERE id_cotizacion = :id_cotizacion";
        List<cotizacionModel> list = entityManager.createQuery(query)
                .setParameter("id_cotizacion", idconverter)
                .getResultList();
        return list;
    }

    @Override
    public void deletecotizacion(Long id_cotizacion) {
        cotizacionModel cotizacion = entityManager.find(cotizacionModel.class, id_cotizacion);
        entityManager.remove(cotizacion);
    }

    @Override
    public void editClliente(cotizacionModel cotizacion, Long id_cotizacion) {
        cotizacionModel cotizacionBuscado = entityManager.find(cotizacionModel.class, id_cotizacion);
        cotizacionBuscado = cotizacion;
        entityManager.merge(cotizacionBuscado);
    }
}
