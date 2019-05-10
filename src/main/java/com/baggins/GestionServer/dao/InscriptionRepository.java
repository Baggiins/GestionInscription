package com.baggins.GestionServer.dao;

import com.baggins.GestionServer.modele.InscriptionEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Classe Repository de InscriptionEntity
 * @author baggins
 */
@Repository
public interface InscriptionRepository extends CrudRepository<InscriptionEntity, Long> {
    /**
     * @return la liste complète d'inscriptions stockés
     */
    List<InscriptionEntity> findAllBy();
}
