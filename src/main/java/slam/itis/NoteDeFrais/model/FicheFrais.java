package slam.itis.NoteDeFrais.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreUpdate;
@Entity
public class FicheFrais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mois;
    private Integer nbJustificatifs;
    private Double montantValide;
    private LocalDate dateModif;
    private boolean horsForfait;

    


    // Relation avec Visiteur
    @ManyToOne
    @JoinColumn(name = "visiteur_id")

    private Visiteur visiteur;

    
/* 
    // Relation avec LigneFraisForfait
    @OneToMany(mappedBy = "ficheFrais", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Utilisé pour marquer le côté principal de la relation
    private List<LigneFraisForfait> lignesFraisForfait;

    // Relation avec LigneFraisHorsForfait
    @OneToMany(mappedBy = "ficheFrais", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference // Utilisé pour marquer le côté principal de la relation
    private List<LigneFraisHorsForfait> lignesFraisHorsForfait;
    */

    // Mise à jour automatique de la dateModif lors d'une mise à jour
    @PreUpdate
    protected void onUpdate() {
        this.dateModif = LocalDate.now();
    }

    // Getters et Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMois() { return mois; }
    public void setMois(String mois) { this.mois = mois; }

    public Integer getNbJustificatifs() { return nbJustificatifs; }
    public void setNbJustificatifs(Integer nbJustificatifs) { this.nbJustificatifs = nbJustificatifs; }

    public Double getMontantValide() { return montantValide; }
    public void setMontantValide(Double montantValide) { this.montantValide = montantValide; }

    public LocalDate getDateModif() { return dateModif; }
    public void setDateModif(LocalDate dateModif) { this.dateModif = dateModif; }

    public Visiteur getVisiteur() { return visiteur; }
    public void setVisiteur(Visiteur visiteur) { this.visiteur = visiteur; }

    public boolean isHorsForfait() { return horsForfait; }
    public void setHorsForfait(boolean horsForfait) { this.horsForfait = horsForfait; }
/* 
    public List<LigneFraisForfait> getLignesFraisForfait() { return lignesFraisForfait; }
    public void setLignesFraisForfait(List<LigneFraisForfait> lignesFraisForfait) { this.lignesFraisForfait = lignesFraisForfait; }

    public List<LigneFraisHorsForfait> getLignesFraisHorsForfait() { return lignesFraisHorsForfait; }
    public void setLignesFraisHorsForfait(List<LigneFraisHorsForfait> lignesFraisHorsForfait) { this.lignesFraisHorsForfait = lignesFraisHorsForfait; }
    */
}