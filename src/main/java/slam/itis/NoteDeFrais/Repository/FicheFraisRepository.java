package slam.itis.NoteDeFrais.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import slam.itis.NoteDeFrais.model.FicheFrais;

@Repository
public interface FicheFraisRepository extends JpaRepository<FicheFrais, Long> {
    List<FicheFrais> findByMois(String mois);
    List<FicheFrais> findByVisiteurId(Long visiteurId);
}
