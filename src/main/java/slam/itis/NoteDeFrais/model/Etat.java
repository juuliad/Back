package slam.itis.NoteDeFrais.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Etat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;

    // Relation avec FicheFrais
    @OneToMany(mappedBy = "etat", cascade = CascadeType.ALL)
    private List<FicheFrais> fichesFrais;

    // Constructeurs

    public Etat(String libelle) {
        this.libelle = libelle;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public List<FicheFrais> getFichesFrais() {
        return fichesFrais;
    }

    public void setFichesFrais(List<FicheFrais> fichesFrais) {
        this.fichesFrais = fichesFrais;
    }
}
