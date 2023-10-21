package com.example.Backend.dao;

import com.example.Backend.models.motoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class motoDaoImp implements motoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void postmoto(motoModel moto) {
        entityManager.merge(moto);
    }

    @Override
    public List<motoModel> getmotos() {
        String query = "FROM motoModel";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<motoModel> getmoto(Long id_moto) {
        String idconverter = Long.toString(id_moto);
        String query = "FROM motoModel WHERE id_moto = :id_moto";
        List<motoModel> list = entityManager.createQuery(query)
                .setParameter("id_moto", idconverter)
                .getResultList();
        return list;
    }

    @Override
    public void deletemoto(Long id_moto) {
        motoModel moto = entityManager.find(motoModel.class, id_moto);
        entityManager.remove(moto);
    }

    @Override
    public void editClliente(motoModel moto, Long id_moto) {
        motoModel motoBuscado = entityManager.find(motoModel.class, id_moto);
        motoBuscado = moto;
        entityManager.merge(motoBuscado);
    }
}
