package slam.itis.notedefrais.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import slam.itis.notedefrais.model.FicheFrais;

@Repository
public interface FicheFraisRepository extends JpaRepository<FicheFrais, Long> {
    // Exemple de méthode pour trouver les fiches par mois
    List<FicheFrais> findByMois(String mois);

    // Exemple : trouver les fiches par visiteur
    List<FicheFrais> findByVisiteurId(Long visiteurId);
}
