package slam.itis.NoteDeFrais.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import slam.itis.NoteDeFrais.Repository.FraisForfaitRepository;
import slam.itis.NoteDeFrais.model.FraisForfait;

@Service
public class FraisForfaitService {

    private final FraisForfaitRepository fraisForfaitRepository;

    
    public FraisForfaitService(FraisForfaitRepository fraisForfaitRepository) {
        this.fraisForfaitRepository = fraisForfaitRepository;
    }

    public List<FraisForfait> getAllFraisForfaits() {
        return fraisForfaitRepository.findAll();
    }

    public Optional<FraisForfait> getFraisForfaitById(Long id) {
        return fraisForfaitRepository.findById(id);
    }

    public FraisForfait createFraisForfait(FraisForfait fraisForfait) {
        return fraisForfaitRepository.save(fraisForfait);
    }

    public FraisForfait updateFraisForfait(Long id, FraisForfait fraisForfait) {
        if (!fraisForfaitRepository.existsById(id)) {
            throw new IllegalArgumentException("FraisForfait with ID " + id + " does not exist.");
        }
        fraisForfait.setId(id);
        return fraisForfaitRepository.save(fraisForfait);
    }

    public void deleteFraisForfait(Long id) {
        if (!fraisForfaitRepository.existsById(id)) {
            throw new IllegalArgumentException("FraisForfait with ID " + id + " does not exist.");
        }
        fraisForfaitRepository.deleteById(id);
    }
}
