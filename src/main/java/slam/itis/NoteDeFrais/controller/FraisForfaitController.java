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

import slam.itis.NoteDeFrais.model.FraisForfait;
import slam.itis.NoteDeFrais.service.FraisForfaitService;

@RestController
@RequestMapping("/api/fraisForfait")
public class FraisForfaitController {

    @Autowired
    private FraisForfaitService service;

    // 🔹 Récupérer tous les frais forfait
    @GetMapping
    public List<FraisForfait> getAllFraisForfaits() {
        return service.getAllFraisForfaits();
    }

    // 🔹 Récupérer un frais forfait par ID
    @GetMapping("/{id}")
    public ResponseEntity<FraisForfait> getFraisForfaitById(@PathVariable Long id) {
        return service.getFraisForfaitById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Ajouter un nouveau frais forfait
    @PostMapping
    public ResponseEntity<FraisForfait> createFraisForfait(@RequestBody FraisForfait fraisForfait) {
        FraisForfait newFraisForfait = service.createFraisForfait(fraisForfait);
        return ResponseEntity.status(HttpStatus.CREATED).body(newFraisForfait);
    }

    // 🔹 Modifier un frais forfait existant
    @PutMapping("/{id}")
    public ResponseEntity<FraisForfait> updateFraisForfait(@PathVariable Long id, @RequestBody FraisForfait fraisForfait) {
        try {
            FraisForfait updatedFraisForfait = service.updateFraisForfait(id, fraisForfait);
            return ResponseEntity.ok(updatedFraisForfait);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Supprimer un frais forfait
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFraisForfait(@PathVariable Long id) {
        try {
            service.deleteFraisForfait(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Récupérer un frais forfait par libellé
    @GetMapping("/libelle/{libelle}")
    public ResponseEntity<FraisForfait> getFraisForfaitByLibelle(@PathVariable String libelle) {
        FraisForfait fraisForfait = service.getAllFraisForfaits()
            .stream()
            .filter(f -> f.getLibelle().equalsIgnoreCase(libelle))
            .findFirst()
            .orElse(null);
        
        return (fraisForfait != null) ? ResponseEntity.ok(fraisForfait) : ResponseEntity.notFound().build();
    }
}

