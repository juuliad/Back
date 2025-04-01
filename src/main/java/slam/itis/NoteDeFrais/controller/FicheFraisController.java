package slam.itis.NoteDeFrais.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "Content-Type")
@RestController
@RequestMapping("/api/ficheFrais")
public class FicheFraisController {

    private final FicheFraisService service;

    public FicheFraisController(FicheFraisService service) {
        this.service = service;
    }

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
            .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).body(null));
    }

    // 🔹 Ajouter une nouvelle fiche de frais
    @PostMapping
    public ResponseEntity<FicheFrais> createFicheFrais(@RequestBody FicheFrais ficheFrais) {
       // System.out.println("FicheFrais reçue : " + ficheFrais);
        // Vérification et réinitialisation de l'ID pour éviter tout conflit
        //ficheFrais.setId(null);
        FicheFrais newFicheFrais = service.createFicheFrais(ficheFrais);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFicheFrais);
    }
    
    // 🔹 Modifier une fiche de frais existante
    @PutMapping("/{id}")
    public ResponseEntity<?> updateFicheFrais(@PathVariable Long id, @RequestBody FicheFrais ficheFrais) {
        try {
            ficheFrais.setId(id); // Assure que l'objet a bien le bon ID
            FicheFrais updatedFiche = service.updateFicheFrais(ficheFrais, id);
            return ResponseEntity.ok(updatedFiche);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("⚠ FicheFrais non trouvée pour l'ID: " + id);
        }
    }

    // 🔹 Supprimer une fiche de frais
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFicheFrais(@PathVariable Long id) {
        try {
            service.deleteFicheFrais(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("⚠ Impossible de supprimer, ID introuvable : " + id);
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
