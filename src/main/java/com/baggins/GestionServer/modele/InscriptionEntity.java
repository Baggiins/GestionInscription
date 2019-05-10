package com.baggins.GestionServer.modele;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;

/**
 * Classe d'entité corespondant à INSCRIPTION dans la base de donnée
 * @author baggins
 */
@Entity
@Table(name = "INSCRIPTION", schema = "PUBLIC", catalog = "DATABASE")
public class InscriptionEntity implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    private long id;
    @Basic
    @Column(name = "CODE_POSTAL", nullable = false, length = 6)
    private String codePostal;
    @Basic
    @Column(name = "COMMUNE", nullable = false, length = 50)
    private String commune;
    @Basic
    @Column(name = "NUMERO_ET_VOIE", nullable = false, length = 100)
    private String numeroEtVoie;
    @Basic
    @Column(name = "PAYS", nullable = false, length = 50)
    private String pays;
    @Basic
    @Column(name = "CIVILITE", nullable = false, length = 3)
    private String civilite;
    @Basic
    @Column(name = "DATE_DE_NAISSANCE", nullable = false)
    private Date dateDeNaissance;
    @Basic
    @Column(name = "NOM", nullable = false, length = 100)
    private String nom;
    @Basic
    @Column(name = "PRENOM", nullable = false, length = 100)
    private String prenom;
    @Basic
    @Column(name = "REFERENCE_DOSSIER", nullable = false, length = 6)
    private String referenceDossier;
    @ManyToOne
    @JoinColumn(name = "DIPLOME_ID", referencedColumnName = "ID", nullable = false)
    private DiplomeEntity diplomeByDiplomeId;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }


    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }


    public String getNumeroEtVoie() {
        return numeroEtVoie;
    }

    public void setNumeroEtVoie(String numeroEtVoie) {
        this.numeroEtVoie = numeroEtVoie;
    }


    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }


    public String getCivilite() {
        return civilite;
    }

    public void setCivilite(String civilite) {
        this.civilite = civilite;
    }


    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getReferenceDossier() {
        return referenceDossier;
    }

    public void setReferenceDossier(String referenceDossier) {
        this.referenceDossier = referenceDossier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscriptionEntity that = (InscriptionEntity) o;
        return id == that.id &&
                Objects.equals(codePostal, that.codePostal) &&
                Objects.equals(commune, that.commune) &&
                Objects.equals(numeroEtVoie, that.numeroEtVoie) &&
                Objects.equals(pays, that.pays) &&
                Objects.equals(civilite, that.civilite) &&
                Objects.equals(dateDeNaissance, that.dateDeNaissance) &&
                Objects.equals(nom, that.nom) &&
                Objects.equals(prenom, that.prenom) &&
                Objects.equals(referenceDossier, that.referenceDossier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codePostal, commune, numeroEtVoie, pays, civilite, dateDeNaissance, nom, prenom, referenceDossier);
    }


    public DiplomeEntity getDiplomeByDiplomeId() {
        return diplomeByDiplomeId;
    }

    public void setDiplomeByDiplomeId(DiplomeEntity diplomeByDiplomeId) {
        this.diplomeByDiplomeId = diplomeByDiplomeId;
    }
}
