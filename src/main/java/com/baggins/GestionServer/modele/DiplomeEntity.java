package com.baggins.GestionServer.modele;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe d'entité corespondant à DIPLOME dans la base de donnée
 * @author baggins
 */
@Entity
@Table(name = "DIPLOME", schema = "PUBLIC", catalog = "DATABASE")
public class DiplomeEntity implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    private long id;
    @Basic
    @Column(name = "CODE", nullable = false, length = 6)
    private String code;
    @Basic
    @Column(name = "DESCRIPTIF", nullable = true, length = 4000)
    private String descriptif;
    @Basic
    @Column(name = "ENSEIGNANT_RESPONSABLE", nullable = true, length = 255)
    private String enseignantResponsable;
    @Basic
    @Column(name = "LIBELLE", nullable = false, length = 100)
    private String libelle;
    @ManyToOne
    @JoinColumn(name = "TYPE_ID")
    private TypeDiplomeEntity typeDiplome;
    @OneToMany(mappedBy = "diplomeByDiplomeId", cascade = CascadeType.ALL)
    Set<InscriptionEntity> Inscription = new HashSet<InscriptionEntity>();
    @Embedded
    private DiplomeUnitesEntity diplomeUnites;

    public TypeDiplomeEntity getTypeDiplome() {
        return typeDiplome;
    }

    public void setTypeDiplome(TypeDiplomeEntity typeDiplome) {
        this.typeDiplome = typeDiplome;
    }

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


    public String getDescriptif() {
        return descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }


    public String getEnseignantResponsable() {
        return enseignantResponsable;
    }

    public void setEnseignantResponsable(String enseignantResponsable) {
        this.enseignantResponsable = enseignantResponsable;
    }


    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiplomeEntity that = (DiplomeEntity) o;
        return id == that.id &&
                Objects.equals(code, that.code) &&
                Objects.equals(descriptif, that.descriptif) &&
                Objects.equals(enseignantResponsable, that.enseignantResponsable) &&
                Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, descriptif, enseignantResponsable, libelle);
    }
}
