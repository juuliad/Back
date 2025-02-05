package slam.itis.NoteDeFrais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

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
        return ficheFraisRepository.save(ficheFrais);
    }

    public FicheFrais updateFicheFrais(FicheFrais ficheFrais, Long id) {
        if (!ficheFraisRepository.existsById(id)) {
            throw new IllegalArgumentException("FicheFrais avec ID " + id + " introuvable.");
        }
        ficheFrais.setId(id);
        return ficheFraisRepository.save(ficheFrais);
    }

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

