package slam.itis.NoteDeFrais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import slam.itis.NoteDeFrais.Repository.EtatRepository;
import slam.itis.NoteDeFrais.model.Etat;

@Service
public class EtatService {

    private final EtatRepository etatRepository;

    public EtatService(EtatRepository etatRepository) {
        this.etatRepository = etatRepository;
    }

    public List<Etat> getAllEtats() {
        return etatRepository.findAll();
    }

    public Optional<Etat> getEtatById(Long id) {
        return etatRepository.findById(id);
    }

    public Etat saveEtat(Etat etat) {
        return etatRepository.save(etat);
    }

    public void deleteEtatById(Long id) {
        etatRepository.deleteById(id);
    }
}