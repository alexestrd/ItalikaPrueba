package com.example.Backend.dao;


import com.example.Backend.models.costoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class costoDaoImp implements costoDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void postcosto(costoModel costo) {
        entityManager.merge(costo);
    }

    @Override
    public List<costoModel> getcostos() {
        String query = "FROM costoModel";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<costoModel> getcosto(Long id_costo) {
        String idconverter = Long.toString(id_costo);
        String query = "FROM costoModel WHERE id_costo = :id_costo";
        List<costoModel> list = entityManager.createQuery(query)
                .setParameter("id_costo", idconverter)
                .getResultList();
        return list;
    }

    @Override
    public void deletecosto(Long id_costo) {
        costoModel costo = entityManager.find(costoModel.class, id_costo);
        entityManager.remove(costo);
    }

    @Override
    public void editClliente(costoModel costo, Long id_costo) {
        costoModel costoBuscado = entityManager.find(costoModel.class, id_costo);
        costoBuscado = costo;
        entityManager.merge(costoBuscado);
    }
    
}
