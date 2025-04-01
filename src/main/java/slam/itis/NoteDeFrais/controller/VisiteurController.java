package slam.itis.NoteDeFrais.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import slam.itis.NoteDeFrais.model.LoginRequest;
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

   // VisiteurController.java
@PostMapping("/login")
public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
    Visiteur visiteur = visiteurService.getVisiteurByLogin(loginRequest.getUsername());
    if (visiteur != null && visiteur.getMdp().equals(loginRequest.getPassword())) {
        return ResponseEntity.ok(visiteur); // Retourner l'objet Visiteur
    } else {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Nom d'utilisateur ou mot de passe incorrect");
    }
}
}