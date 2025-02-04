package slam.itis.NoteDeFrais.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import slam.itis.NoteDeFrais.model.Visiteur;
import slam.itis.NoteDeFrais.service.VisiteurService;

@RestController
@RequestMapping("/api/visiteurs")
public class VisiteurController {
    @Autowired
    private VisiteurService visiteurService;

    // Récupérer tous les visiteurs
    @GetMapping
    public List<Visiteur> getAllVisiteurs() {
        return visiteurService.getAllVisiteurs();
    }

    // Récupérer un visiteur par ID
    @GetMapping("/{id}")
    public Optional<Visiteur> getVisiteurById(@PathVariable Long id) {
        return visiteurService.getVisiteurById(id);
    }

    // Ajouter ou mettre à jour un visiteur
    @PostMapping
    public Visiteur saveVisiteur(@RequestBody Visiteur visiteur) {
        return visiteurService.saveVisiteur(visiteur);
    }

    // Supprimer un visiteur
    @DeleteMapping("/{id}")
    public void deleteVisiteur(@PathVariable Long id) {
        visiteurService.deleteVisiteur(id);
    }

    // Récupérer les visiteurs par ville
    @GetMapping("/ville/{ville}")
    public List<Visiteur> getVisiteursByVille(@PathVariable String ville) {
        return visiteurService.getVisiteursByVille(ville);
    }

    // Récupérer les visiteurs embauchés après une date
    @GetMapping("/embaucheApres/{date}")
    public List<Visiteur> getVisiteursEmbauchesApres(@PathVariable String date) {
        LocalDate localDate = LocalDate.parse(date); // Conversion String → LocalDate
        return visiteurService.getVisiteursEmbauchesApres(localDate);
    }

    // Récupérer un visiteur par login
    @GetMapping("/login/{login}")
    public Visiteur getVisiteurByLogin(@PathVariable String login) {
        return visiteurService.getVisiteurByLogin(login);
    }
}
