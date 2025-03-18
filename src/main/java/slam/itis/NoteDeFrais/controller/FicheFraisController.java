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

import slam.itis.NoteDeFrais.model.FicheFrais;
import slam.itis.NoteDeFrais.service.FicheFraisService;

@RestController
@RequestMapping("/api/ficheFrais")
public class FicheFraisController {

    @Autowired
    private FicheFraisService service;

    // 🔹 Récupérer toutes les fiches de frais
    @GetMapping
    public List<FicheFrais> getAllFicheFrais() {
        return service.getAllFicheFrais();
    }

    // 🔹 Récupérer une fiche de frais par ID
    @GetMapping("/{id}")
    public ResponseEntity<FicheFrais> getFicheFraisById(@PathVariable Long id) {
        return service.getFicheFraisById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Ajouter une nouvelle fiche de frais
    @PostMapping
    public ResponseEntity<FicheFrais> createFicheFrais(@RequestBody FicheFrais ficheFrais) {
        System.out.println("📩 Nouvelle fiche de frais reçue : " + ficheFrais);
        FicheFrais newFicheFrais = service.createFicheFrais(ficheFrais);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFicheFrais);
    }
    

    // 🔹 Modifier une fiche de frais existante
    @PutMapping("/{id}")
    public ResponseEntity<FicheFrais> updateFicheFrais(@PathVariable Long id, @RequestBody FicheFrais ficheFrais) {
        try {
            FicheFrais updatedFiche = service.updateFicheFrais(ficheFrais, id);
            return ResponseEntity.ok(updatedFiche);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Supprimer une fiche de frais
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFicheFrais(@PathVariable Long id) {
        try {
            service.deleteFicheFrais(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Récupérer les fiches par mois
    @GetMapping("/mois/{mois}")
    public List<FicheFrais> getFicheFraisByMois(@PathVariable String mois) {
        return service.getFicheFraisByMois(mois);
    }

    // 🔹 Récupérer les fiches par visiteur
    @GetMapping("/visiteur/{visiteurId}")
    public List<FicheFrais> getFicheFraisByVisiteur(@PathVariable Long visiteurId) {
        return service.getFicheFraisByVisiteur(visiteurId);
    }
}

