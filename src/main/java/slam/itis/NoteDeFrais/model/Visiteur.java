package slam.itis.NoteDeFrais.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Visiteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String ville;
    private String cp;
    private LocalDate dateEmbauche;
    private String login;
    private String mdp;

        // Constructeur par défaut
        public Visiteur() {
            // Ce constructeur peut rester vide
        }
    // Relation avec FicheFrais
    @OneToMany(mappedBy = "visiteur", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<FicheFrais> fichesFrais;

    // Constructeurs

    public Visiteur(String nom, String prenom, String adresse, String ville, String cp, LocalDate dateEmbauche, String login, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.ville = ville;
        this.cp = cp;
        this.dateEmbauche = dateEmbauche;
        this.login = login;
        this.mdp = mdp;
    }

    // Getters et Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    public void setDateEmbauche(LocalDate dateEmbauche) {
        this.dateEmbauche = dateEmbauche;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public List<FicheFrais> getFichesFrais() {
        return fichesFrais;
    }

    public void setFichesFrais(List<FicheFrais> fichesFrais) {
        this.fichesFrais = fichesFrais;
    }
    
}
