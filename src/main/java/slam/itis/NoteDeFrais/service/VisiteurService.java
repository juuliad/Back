package slam.itis.NoteDeFrais.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slam.itis.NoteDeFrais.Repository.VisiteurRepository;
import slam.itis.NoteDeFrais.model.Visiteur;

@Service
public class VisiteurService {

    @Autowired
    private VisiteurRepository visiteurRepository;

    public List<Visiteur> getAllVisiteurs() {
        return visiteurRepository.findAll();
    }

    public Optional<Visiteur> getVisiteurById(Long id) {
        return visiteurRepository.findById(id);
    }

    public Visiteur saveVisiteur(Visiteur visiteur) {
        return visiteurRepository.save(visiteur);
    }

    public void deleteVisiteur(Long id) {
        visiteurRepository.deleteById(id);
    }

    public List<Visiteur> getVisiteursByVille(String ville) {
        return visiteurRepository.findByVille(ville);
    }

    public List<Visiteur> getVisiteursEmbauchesApres(LocalDate date) {
        return visiteurRepository.findByDateEmbaucheAfter(date);
    }

    public Visiteur getVisiteurByLogin(String login) {
        return visiteurRepository.findByLogin(login);
    }
}

