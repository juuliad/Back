package slam.itis.NoteDeFrais.controller;

import java.util.List;

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
@RequestMapping("/api/noteFrais")
public class FicheFraisController {

    private final FicheFraisService noteFraisService;

    public FicheFraisController(FicheFraisService noteFraisService) {
        this.noteFraisService = noteFraisService;
    }

    @GetMapping
    public List<FicheFrais> getAllFicheFrais() {
        return noteFraisService.getAllFicheFrais();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FicheFrais> getFicheFraisById(@PathVariable Long id) {
        FicheFrais ficheFrais = noteFraisService.getFicheFraisById(id).get();
        return ficheFrais != null ? ResponseEntity.ok(ficheFrais) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FicheFrais> saveOrUpdateFicheFrais(@RequestBody FicheFrais ficheFrais) {
        FicheFrais createdFicheFrais = new FicheFrais(null, null, null, null, null, null);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFicheFrais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FicheFrais> updateFicheFrais(@PathVariable Long id, @RequestBody FicheFrais productDetails) {
        FicheFrais updatedFicheFrais = new FicheFrais(null, null, null, null, null, null);
        return updatedFicheFrais != null ? ResponseEntity.ok(updatedFicheFrais) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFicheFrais(@PathVariable("id") Long id) {
        FicheFraisService.deleteFicheFrais(id);
    }
}
