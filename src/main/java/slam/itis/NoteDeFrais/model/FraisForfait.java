package slam.itis.NoteDeFrais.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class FraisForfait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String libelle;
    private Double montant;

    // Relation avec LigneFraisForfait (OneToMany : un type de frais peut être utilisé dans plusieurs lignes)
    @OneToMany(mappedBy = "fraisForfait", cascade = CascadeType.ALL)
    private List<LigneFraisForfait> lignesFraisForfait;

    // Constructeurs

    public FraisForfait(String libelle, Double montant) {
        this.libelle = libelle;
        this.montant = montant;
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

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public List<LigneFraisForfait> getLignesFraisForfait() {
        return lignesFraisForfait;
    }

    public void setLignesFraisForfait(List<LigneFraisForfait> lignesFraisForfait) {
        this.lignesFraisForfait = lignesFraisForfait;
    }
}
