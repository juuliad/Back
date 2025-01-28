package slam.itis.NoteDeFrais.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class LigneFraisForfait {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mois;

    // Relation avec FicheFrais
    @ManyToOne
    @JoinColumn(name = "fiche_frais_id", nullable = false) // Clé étrangère
    private FicheFrais ficheFrais;

    // Relation avec FraisForfait (ManyToOne : chaque ligne correspond à un type de frais)
    @ManyToOne
    @JoinColumn(name = "frais_forfait_id", nullable = false) // Clé étrangère
    private FraisForfait fraisForfait;

    // Relation avec Visiteur
    @ManyToOne
    @JoinColumn(name = "visiteur_id", nullable = false) // Clé étrangère
    private Visiteur visiteur;

    // Constructeurs
    public LigneFraisForfait(FicheFrais ficheFrais, FraisForfait fraisForfait, Visiteur visiteur) {
        this.ficheFrais = ficheFrais;
        this.fraisForfait = fraisForfait;
        this.visiteur = visiteur;

    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public FicheFrais getFicheFrais() {
        return ficheFrais;
    }

    public void setFicheFrais(FicheFrais ficheFrais){
        this.ficheFrais = ficheFrais;
    }

    public String getMois() {
        return mois;
    }

    public void setMois(String mois) {
        this.mois = mois;
    }
}
