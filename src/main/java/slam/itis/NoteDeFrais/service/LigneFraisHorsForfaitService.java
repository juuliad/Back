package slam.itis.NoteDeFrais.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slam.itis.NoteDeFrais.Repository.LigneFraisHorsForfaitRepository;
import slam.itis.NoteDeFrais.model.LigneFraisHorsForfait;

@Service
public class LigneFraisHorsForfaitService {

    @Autowired
    private LigneFraisHorsForfaitRepository repository;

    public List<LigneFraisHorsForfait> getAllLignes() {
        return repository.findAll();
    }

    public LigneFraisHorsForfait getLigneById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public LigneFraisHorsForfait saveLigne(LigneFraisHorsForfait ligne) {
        return repository.save(ligne);
    }

    public void deleteLigne(Long id) {
        repository.deleteById(id);
    }

    public List<LigneFraisHorsForfait> getLignesByDate(LocalDate date) {
        return repository.findByDate(date);
    }

    public List<LigneFraisHorsForfait> getLignesByMontantGreaterThan(Double montant) {
        return repository.findByMontantGreaterThan(montant);
    }

    public List<LigneFraisHorsForfait> getLignesByLibelleContaining(String keyword) {
        return repository.findByLibelleContaining(keyword);
    }

    public List<LigneFraisHorsForfait> getLignesByFicheFraisId(Long ficheFraisId) {
        return repository.findByFicheFraisId(ficheFraisId);
    }
}

