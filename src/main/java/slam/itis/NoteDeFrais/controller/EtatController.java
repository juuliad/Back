package slam.itis.NoteDeFrais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import slam.itis.NoteDeFrais.model.Etat;
import slam.itis.NoteDeFrais.service.EtatService;

@RestController
@RequestMapping("/api/etats")
public class EtatController {

    @Autowired
    private EtatService etatService;

    // 🔹 Récupérer tous les états
    @GetMapping
    public List<Etat> getAllEtats() {
        return etatService.getAllEtats();
    }

    // 🔹 Récupérer un état par ID
    @GetMapping("/{id}")
    public ResponseEntity<Etat> getEtatById(@PathVariable Long id) {
        return etatService.getEtatById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    // 🔹 Ajouter un nouvel état
    @PostMapping
    public ResponseEntity<Etat> createEtat(@RequestBody Etat etat) {
        Etat newEtat = etatService.saveEtat(etat);
        return ResponseEntity.status(HttpStatus.CREATED).body(newEtat);
    }

    // 🔹 Supprimer un état
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtat(@PathVariable Long id) {
        try {
            etatService.deleteEtatById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // 🔹 Récupérer un état par libellé
    @GetMapping("/libelle/{libelle}")
    public ResponseEntity<Etat> getEtatByLibelle(@PathVariable String libelle) {
        Etat etat = etatService.getEtatByLibelle(libelle);
        return etat != null ? ResponseEntity.ok(etat) : ResponseEntity.notFound().build();
    }
}
