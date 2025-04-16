package slam.itis.NoteDeFrais.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import slam.itis.NoteDeFrais.Repository.FicheFraisRepository;
import slam.itis.NoteDeFrais.model.FicheFrais;

@Service
public class FicheFraisService {

    private final FicheFraisRepository ficheFraisRepository;

    public FicheFraisService(FicheFraisRepository ficheFraisRepository) {
        this.ficheFraisRepository = ficheFraisRepository;
    }

    public List<FicheFrais> getAllFicheFrais() {
        return ficheFraisRepository.findAll();
    }

    public Optional<FicheFrais> getFicheFraisById(Long id) {
        return ficheFraisRepository.findById(id);
    }

    public FicheFrais createFicheFrais(FicheFrais ficheFrais) {
        if (ficheFrais == null) {
            throw new IllegalArgumentException("La fiche frais ne peut pas être null.");
        }

        // ⚠️ Détection automatique du hors forfait
        ficheFrais.setHorsForfait(ficheFrais.getMontantValide() != null && ficheFrais.getMontantValide() > 150);
        ficheFrais.setDateModif(LocalDate.now());

        return ficheFraisRepository.save(ficheFrais);
    }

    @Transactional
    public FicheFrais updateFicheFrais(FicheFrais ficheFrais, Long id) {
        System.out.println("Mise à jour de la fiche de frais ID: " + id);

        FicheFrais existingFiche = ficheFraisRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("FicheFrais non trouvée avec ID: " + id));

        if (ficheFrais.getMontantValide() != null) {
            existingFiche.setMontantValide(ficheFrais.getMontantValide());
        }

        if (ficheFrais.getNbJustificatifs() != null) {
            existingFiche.setNbJustificatifs(ficheFrais.getNbJustificatifs());
        }

        // ⚠️ Mise à jour du statut hors forfait automatiquement
        existingFiche.setHorsForfait(existingFiche.getMontantValide() != null && existingFiche.getMontantValide() > 150);

        existingFiche.setDateModif(LocalDate.now());

        return ficheFraisRepository.save(existingFiche);
    }

    @Transactional
    public void deleteFicheFrais(Long id) {
        if (!ficheFraisRepository.existsById(id)) {
            throw new IllegalArgumentException("FicheFrais avec ID " + id + " introuvable.");
        }
        ficheFraisRepository.deleteById(id);
    }

    public List<FicheFrais> getFicheFraisByMois(String mois) {
        return ficheFraisRepository.findByMois(mois);
    }

    public List<FicheFrais> getFicheFraisByVisiteur(Long visiteurId) {
        return ficheFraisRepository.findByVisiteurId(visiteurId);
    }
}