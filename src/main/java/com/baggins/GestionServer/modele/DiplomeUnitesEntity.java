package com.baggins.GestionServer.modele;

import javax.persistence.*;

/**
 * Classe "embarqué" corespondant à DIPLOME_UNITES dans la base de donnée
 * @author baggins
 */
@Embeddable
@Table(name = "DIPLOME_UNITES")
public class DiplomeUnitesEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    private DiplomeEntity Diplome;

    @OneToOne(cascade = CascadeType.ALL)
    private UniteEnseignementEntity uniteEnseignement;
}
