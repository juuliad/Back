package slam.itis.NoteDeFrais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import slam.itis.NoteDeFrais.model.LigneFraisForfait;
import slam.itis.NoteDeFrais.service.LigneFraisForfaitService;

@RestController
@RequestMapping("/api/lignesFraisForfait")
public class LigneFraisForfaitController {

    @Autowired
    private LigneFraisForfaitService service;

    // 🔹 Récupérer toutes les lignes de frais forfait
    @GetMapping
    public List<LigneFraisForfait> getAllLignes() {
        return service.getAllLignes();
    }

    // 🔹 Récupérer une ligne de frais forfait par ID
    @GetMapping("/{id}")
    public ResponseEntity<LigneFraisForfait> getLigneById(@PathVariable Long id) {
        return service.getAllLignes().stream()
            .filter(ligne -> ligne.getId().equals(id))
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Ajouter une nouvelle ligne de frais forfait
    @PostMapping
    public ResponseEntity<LigneFraisForfait> createLigne(@RequestBody LigneFraisForfait ligne) {
        LigneFraisForfait newLigne = service.saveLigne(ligne);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLigne);
    }

    // 🔹 Modifier une ligne existante
    @PutMapping("/{id}")
    public ResponseEntity<LigneFraisForfait> updateLigne(@PathVariable Long id, @RequestBody LigneFraisForfait ligne) {
        LigneFraisForfait existingLigne = service.getAllLignes().stream()
            .filter(l -> l.getId().equals(id))
            .findFirst()
            .orElse(null);

        if (existingLigne == null) {
            return ResponseEntity.notFound().build();
        }

        existingLigne.setMois(ligne.getMois());
        existingLigne.setFicheFrais(ligne.getFicheFrais());

        LigneFraisForfait updatedLigne = service.saveLigne(existingLigne);
        return ResponseEntity.ok(updatedLigne);
    }

    // 🔹 Supprimer une ligne de frais forfait
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLigne(@PathVariable Long id) {
        if (service.getAllLignes().stream().noneMatch(ligne -> ligne.getId().equals(id))) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    // 🔹 Récupérer les lignes d'une fiche de frais spécifique
    @GetMapping("/ficheFrais/{ficheFraisId}")
    public List<LigneFraisForfait> getLignesByFicheFrais(@PathVariable Long ficheFraisId) {
        return service.getLignesByFicheFrais(ficheFraisId);
    }

    // 🔹 Récupérer les lignes d'un visiteur spécifique
    @GetMapping("/visiteur/{visiteurId}")
    public List<LigneFraisForfait> getLignesByVisiteur(@PathVariable Long visiteurId) {
        return service.getLignesByVisiteur(visiteurId);
    }

    // 🔹 Récupérer les lignes d'un mois donné
    @GetMapping("/mois/{mois}")
    public List<LigneFraisForfait> getLignesByMois(@PathVariable String mois) {
        return service.getLignesByMois(mois);
    }
}

