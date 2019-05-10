package com.baggins.GestionServer.dao;

import com.baggins.GestionServer.modele.DiplomeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Classe Repository de DiplomeEntity
 * @author baggins
 */
@Repository
public interface DiplomeRepository extends CrudRepository<DiplomeEntity, Long> {

    DiplomeEntity findById(long id);

    /**
     * @return la liste complète de diplomes stockés
     */
    List<DiplomeEntity> findAllBy();

}
