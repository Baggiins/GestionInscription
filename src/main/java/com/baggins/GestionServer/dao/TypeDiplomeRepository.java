package com.baggins.GestionServer.dao;

import com.baggins.GestionServer.modele.TypeDiplomeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Classe Repository de TypeDiplomeEntity
 * @author baggins
 */
@Repository
public interface TypeDiplomeRepository extends CrudRepository<TypeDiplomeEntity, Long> {
    /**
     * @return la liste complète des type de diplome stocké
     */
    List<TypeDiplomeEntity> findAllBy();
}
