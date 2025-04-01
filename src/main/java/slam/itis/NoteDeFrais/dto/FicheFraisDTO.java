package slam.itis.NoteDeFrais.dto;

import java.time.LocalDate;

import slam.itis.NoteDeFrais.model.Visiteur;

public class FicheFraisDTO {

    private Long id;
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
    public Long getIdVisiteur() {
        return idVisiteur;
    }
    public void setIdVisiteur(Visiteur visiteur) {
        this.idVisiteur = visiteur.getId();
    }
    private String mois;
    private Integer nbJustificatifs;
    private Double montantValide;
    private LocalDate dateModif;
    private Long idVisiteur;
    public Long getIdEtat() {
        return idEtat;
    }
    public void setIdEtat(Long idEtat) {
        this.idEtat = idEtat;
    }
    private Long idEtat;
}