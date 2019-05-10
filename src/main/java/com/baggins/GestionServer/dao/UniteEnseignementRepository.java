package com.baggins.GestionServer.dao;

import com.baggins.GestionServer.modele.UniteEnseignementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Classe Repository de UniteEnseignementEntity
 * @author baggins
 */
@Repository
public interface UniteEnseignementRepository extends CrudRepository<UniteEnseignementEntity, Long> {
    /**
     * @return la liste complète des unités d'enseignements stocké
     */
    List<UniteEnseignementEntity> findAllBy();
}
