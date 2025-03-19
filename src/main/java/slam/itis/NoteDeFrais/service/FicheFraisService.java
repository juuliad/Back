package slam.itis.notedefrais.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import slam.itis.notedefrais.Repository.FicheFraisRepository;
import slam.itis.notedefrais.dto.FicheFraisDTO;
import slam.itis.notedefrais.model.FicheFrais;

@Service
public class  FicheFraisService {
     
@Autowired 
ModelMapper modelMapper; 

    @Autowired
    private FicheFraisRepository ficheFraisRepository;

    public List<FicheFraisDTO> getAllFicheFrais() {
        List<FicheFrais> fiches = ficheFraisRepository.findAll();
        // Convertir les entités en DTO
        return fiches.stream()
                     .map(this::convertEntityToDto)
                     .collect(Collectors.toList());
    }

    // Méthode pour obtenir une fiche de frais par son ID
    public FicheFraisDTO getFicheFraisById(Long id) {
        Optional<FicheFrais> fiche = ficheFraisRepository.findById(id);
        return fiche.map(this::convertEntityToDto).orElse(null);
    }

    // Méthode pour enregistrer une fiche de frais
    public FicheFraisDTO saveFicheFrais(FicheFraisDTO ficheFraisDTO) {
        FicheFrais ficheFrais = convertDtoToEntity(ficheFraisDTO);
        FicheFrais savedFicheFrais = ficheFraisRepository.save(ficheFrais);
        return convertEntityToDto(savedFicheFrais);
    }

    // Méthode pour mettre à jour une fiche de frais
    public FicheFraisDTO updateFicheFrais(FicheFraisDTO ficheFraisDTO) {
        // On récupère l'ID de la fiche de frais et on la met à jour
        FicheFrais ficheFrais =  convertDtoToEntity(ficheFraisDTO);
        FicheFrais updatedFicheFrais = ficheFraisRepository.save(ficheFrais);
        return convertEntityToDto(updatedFicheFrais);
    }

    // Méthode pour supprimer une fiche de frais par son ID
    public void deleteFicheFrais(Long id) {
        ficheFraisRepository.deleteById(id);
    }

  
    public FicheFraisDTO convertEntityToDto(FicheFrais fichefrais) { 
    modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE); 
    FicheFraisDTO   fichefraisDTO = modelMapper.map(  fichefrais, FicheFraisDTO.class); 
    return   fichefraisDTO ; 
    } 

    public   FicheFrais convertDtoToEntity(FicheFraisDTO fichefraisDto) { 
    FicheFrais fichefrais = new FicheFrais(); 
    fichefrais = modelMapper.map(fichefraisDto,FicheFrais.class); 
    return fichefrais ; 
    }
}