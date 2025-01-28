package slam.itis.NoteDeFrais.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import slam.itis.NoteDeFrais.model.Visiteur;
import slam.itis.NoteDeFrais.service.VisiteurService;

public class VisiteurController {
        private final VisiteurService visiteurService;

    public VisiteurController(VisiteurService visiteurService) {
        this.visiteurService = visiteurService;
    }

    @GetMapping
    public List<Visiteur> getAllVisiteur() {
        return visiteurService.getAllVisiteurs();
    }
}
