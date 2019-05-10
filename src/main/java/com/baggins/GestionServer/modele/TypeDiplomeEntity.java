package com.baggins.GestionServer.modele;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Classe d'entité corespondant à TYPE_DIPLOME dans la base de donnée
 * @author baggins
 */
@Entity
@Table(name = "TYPE_DIPLOME", schema = "PUBLIC", catalog = "DATABASE")
public class TypeDiplomeEntity implements Serializable {
    @Id
    @Column(name = "ID", nullable = false)
    private int id;
    @Basic
    @Column(name = "LIBELLE", nullable = false, length = 20)
    private String libelle;
    @OneToMany(mappedBy = "typeDiplome", cascade = CascadeType.ALL)
    private Set<DiplomeEntity> Diplome = new HashSet<DiplomeEntity>();

    public TypeDiplomeEntity(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public TypeDiplomeEntity() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        TypeDiplomeEntity that = (TypeDiplomeEntity) o;
        return id == that.id &&
                Objects.equals(libelle, that.libelle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, libelle);
    }
}
