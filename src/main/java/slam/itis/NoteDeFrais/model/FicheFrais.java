package slam.itis.NoteDeFrais.model;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class FicheFrais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mois;
    private Integer nbJustificatifs;
    private Double montantValide;
    private LocalDate dateModif;


    // Relation avec Visiteur
    @ManyToOne
    @JoinColumn(name = "visiteur_id") // Clé étrangère
    private Visiteur visiteur;

    // Relation avec Etat
    @ManyToOne
    @JoinColumn(name = "etat_id") // Clé étrangère
    @JsonBackReference
    private Etat etat;

    // Relation avec LigneFraisForfait
    @OneToMany(mappedBy = "ficheFrais", cascade = CascadeType.ALL)
    private List<LigneFraisForfait> lignesFraisForfait;

    // Relation avec LigneFraisHorsForfait
    @OneToMany(mappedBy = "ficheFrais", cascade = CascadeType.ALL)
    private List<LigneFraisHorsForfait> lignesFraisHorsForfait;

   

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }

    public Integer getNbJustificatifs() {
        return nbJustificatifs;
    }

    public void setNbJustificatifs(Integer nbJustificatifs) {
        this.nbJustificatifs = nbJustificatifs;
    }

    public Double getMontantValide() {
        return montantValide;
    }

    public void setMontantValide(Double montantValide) {
        this.montantValide = montantValide;
    }

    public LocalDate getDateModif() {
        return dateModif;
    }

    public void setDateModif(LocalDate dateModif) {
        this.dateModif = dateModif;
    }

    public Visiteur getVisiteur() {
        return visiteur;
    }

    public void setVisiteur(Visiteur visiteur) {
        this.visiteur = visiteur;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public List<LigneFraisForfait> getLignesFraisForfait() {
        return lignesFraisForfait;
    }

    public void setLignesFraisForfait(List<LigneFraisForfait> lignesFraisForfait) {
        this.lignesFraisForfait = lignesFraisForfait;
    }

    public List<LigneFraisHorsForfait> getLignesFraisHorsForfait() {
        return lignesFraisHorsForfait;
    }

    public void setLignesFraisHorsForfait(List<LigneFraisHorsForfait> lignesFraisHorsForfait) {
        this.lignesFraisHorsForfait = lignesFraisHorsForfait;
    }
}