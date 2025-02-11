package slam.itis.notedefrais.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import slam.itis.notedefrais.model.LigneFraisHorsForfait;
import slam.itis.notedefrais.service.LigneFraisHorsForfaitService;

@RestController
@RequestMapping("/api/lignesFraisHorsForfait")
public class LigneFraisHorsForfaitController {

    @Autowired
    private LigneFraisHorsForfaitService service;

    // 🔹 Récupérer toutes les lignes de frais hors forfait
    @GetMapping
    public List<LigneFraisHorsForfait> getAllLignes() {
        return service.getAllLignes();
    }

    // 🔹 Récupérer une ligne par ID
    @GetMapping("/{id}")
    public ResponseEntity<LigneFraisHorsForfait> getLigneById(@PathVariable Long id) {
        LigneFraisHorsForfait ligne = service.getLigneById(id);
        return ligne != null ? ResponseEntity.ok(ligne) : ResponseEntity.notFound().build();
    }

    // 🔹 Ajouter une nouvelle ligne de frais hors forfait
    @PostMapping
    public ResponseEntity<LigneFraisHorsForfait> createLigne(@RequestBody LigneFraisHorsForfait ligne) {
        LigneFraisHorsForfait newLigne = service.saveLigne(ligne);
        return ResponseEntity.status(HttpStatus.CREATED).body(newLigne);
    }

    // 🔹 Modifier une ligne existante
    @PutMapping("/{id}")
    public ResponseEntity<LigneFraisHorsForfait> updateLigne(@PathVariable Long id, @RequestBody LigneFraisHorsForfait ligne) {
        LigneFraisHorsForfait existingLigne = service.getLigneById(id);
        if (existingLigne == null) {
            return ResponseEntity.notFound().build();
        }

        // Mettre à jour les valeurs
        existingLigne.setFicheFrais(ligne.getFicheFrais());
        existingLigne.setDate(ligne.getDate());
        existingLigne.setMontant(ligne.getMontant());
        existingLigne.setLibelle(ligne.getLibelle());

        LigneFraisHorsForfait updatedLigne = service.saveLigne(existingLigne);
        return ResponseEntity.ok(updatedLigne);
    }

    // 🔹 Supprimer une ligne de frais hors forfait
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLigne(@PathVariable Long id) {
        if (service.getLigneById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        service.deleteLigne(id);
        return ResponseEntity.noContent().build();
    }

    // 🔹 Récupérer toutes les lignes d'une fiche frais spécifique
    @GetMapping("/ficheFrais/{ficheFraisId}")
    public List<LigneFraisHorsForfait> getLignesByFicheFrais(@PathVariable Long ficheFraisId) {
        return service.getLignesByFicheFraisId(ficheFraisId);
    }

    // 🔹 Récupérer toutes les lignes d'une date spécifique
    @GetMapping("/date/{date}")
    public List<LigneFraisHorsForfait> getLignesByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return service.getLignesByDate(date);
    }

    // 🔹 Récupérer toutes les lignes dont le montant est supérieur à une valeur donnée
    @GetMapping("/montant/{montant}")
    public List<LigneFraisHorsForfait> getLignesByMontantGreaterThan(@PathVariable Double montant) {
        return service.getLignesByMontantGreaterThan(montant);
    }

    // 🔹 Récupérer toutes les lignes contenant un mot-clé dans le libellé
    @GetMapping("/libelle/{keyword}")
    public List<LigneFraisHorsForfait> getLignesByLibelleContaining(@PathVariable String keyword) {
        return service.getLignesByLibelleContaining(keyword);
    }
}