package com.baggins.GestionServer.modele;

import javax.persistence.*;

/**
 * Classe "embarqué" corespondant à INSCRIPTION_UNITES_OPTIONNELLES dans la base de donnée
 * @author baggins
 */
@Embeddable
@Table(name = "INSCRIPTION_UNITES_OPTIONNELLES", schema = "PUBLIC", catalog = "DATABASE")
public class InscriptionUnitesOptionnellesEntity {
    @OneToOne(cascade = CascadeType.ALL)
    private UniteEnseignementEntity uniteEnseignement;

    @OneToOne(cascade = CascadeType.ALL)
    private InscriptionEntity inscription;
}
