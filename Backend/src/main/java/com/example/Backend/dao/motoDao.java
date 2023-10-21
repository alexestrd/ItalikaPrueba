package com.example.Backend.dao;

import com.example.Backend.models.motoModel;

import java.util.List;

public interface motoDao {

        /*Registra una nueva moto*/
        void postmoto(motoModel moto);

        /*Obtiene todos los motos*/
        List<motoModel> getmotos();

        /*Obtiene un moto*/
        List<motoModel> getmoto(Long id_moto);

        /*Elimina un moto*/
        void deletemoto(Long id_moto);

        void editClliente(motoModel moto, Long id_moto);

}
