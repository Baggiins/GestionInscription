package com.baggins.GestionServer.modele;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Classe d'entité corespondant à UNITE_ENSEIGNEMENT dans la base de donnée
 * @author baggins
 */
@Entity
@Table(name = "UNITE_ENSEIGNEMENT", schema = "PUBLIC", catalog = "DATABASE")
public class UniteEnseignementEntity implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    private long id;
    @Basic
    @Column(name = "CODE", nullable = false, length = 6)
    private String code;
    @Basic
    @Column(name = "LIBELLE", nullable = false, length = 100)
    private String libelle;
    @Basic
    @Column(name = "OBLIGATOIRE", nullable = false)
    private boolean obligatoire;
    /*@Embedded
    private InscriptionUnitesOptionnellesEntity inscriptionUeOptionnelles;*/
    @Embedded
    private DiplomeUnitesEntity diplomeUnites;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public boolean isObligatoire() {
        return obligatoire;
    }

    public void setObligatoire(boolean obligatoire) {
        this.obligatoire = obligatoire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UniteEnseignementEntity that = (UniteEnseignementEntity) o;
        return id == that.id &&
                obligatoire == that.obligatoire &&
                Objects.equals(code, that.code) &&
                Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, libelle, obligatoire);
    }
}
