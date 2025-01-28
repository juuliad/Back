package slam.itis.NoteDeFrais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slam.itis.NoteDeFrais.Repository.FicheFraisRepository;
import slam.itis.NoteDeFrais.model.FicheFrais;

@Service
public class FicheFraisService {

    @Autowired
    private static FicheFraisRepository ficheFraisRepository;
    
        public List<FicheFrais> getAllFicheFrais() {
            return ficheFraisRepository.findAll();
        }
    
    
        public Optional<FicheFrais> getFicheFraisById(Long id) {
            return ficheFraisRepository.findById(id);
        }
    
        public FicheFrais updateFicheFrais(FicheFrais ficheFrais, Long id) {
            return ficheFraisRepository.save(ficheFrais);
        }
    
        public static void deleteFicheFrais(Long id) {
            ficheFraisRepository.deleteById(id);
    }
}
