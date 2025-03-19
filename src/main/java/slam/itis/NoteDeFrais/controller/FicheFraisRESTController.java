package slam.itis.notedefrais.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import slam.itis.notedefrais.dto.FicheFraisDTO;
import slam.itis.notedefrais.service.FicheFraisService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/fichefrais")
public class FicheFraisRESTController {
    @Autowired
    private FicheFraisService fichefraisService;

    @GetMapping("/all")
    public List<FicheFraisDTO> getAllFicheFrais() {
        return fichefraisService.getAllFicheFrais();
    }

    // Récupérer une fiche de frais par son ID
    @GetMapping("/{id}")
    public FicheFraisDTO getFicheFraisById(@PathVariable("id") Long id) {
        return fichefraisService.getFicheFraisById(id);
    }

    @PostMapping("/save")
    public FicheFraisDTO saveFicheFrais(@RequestBody FicheFraisDTO dto) {
        return fichefraisService.saveFicheFrais(dto);
    }


    // Mettre à jour une fiche de frais existante
    @PutMapping("/update/{id}")
    public FicheFraisDTO updateFicheFrais(@PathVariable("id") Long id, @RequestBody FicheFraisDTO ficheFraisDTO) {
        ficheFraisDTO.setId(id);  // Assurez-vous que l'ID est correctement mis à jour
        return fichefraisService.updateFicheFrais(ficheFraisDTO);
    }

    // Supprimer une fiche de frais par son ID
    @DeleteMapping("/delete/{id}")
    public void deleteFicheFrais(@PathVariable("id") Long id) {
        fichefraisService.deleteFicheFrais(id);
    }
}
