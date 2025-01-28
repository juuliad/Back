package slam.itis.NoteDeFrais.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slam.itis.NoteDeFrais.Repository.LigneFraisForfaitRepository;
import slam.itis.NoteDeFrais.model.LigneFraisForfait;

@Service
public class LigneFraisForfaitService {

    @Autowired
    private LigneFraisForfaitRepository repository;

    public List<LigneFraisForfait> getAllLignes() {
        return repository.findAll();
    }

    public List<LigneFraisForfait> getLignesByVisiteur(Long visiteurId) {
        return repository.findByVisiteurId(visiteurId);
    }

    public List<LigneFraisForfait> getLignesByMois(String mois) {
        return repository.findByMois(mois);
    }

    public LigneFraisForfait saveLigne(LigneFraisForfait ligne) {
        return repository.save(ligne);
    }

    public List<LigneFraisForfait> getLignesByFicheFrais(Long ficheFraisId) {
        return repository.findByFicheFraisId(ficheFraisId);
    }
}

