package slam.itis.NoteDeFrais.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import slam.itis.NoteDeFrais.model.LigneFraisForfait;


@Repository
public interface LigneFraisForfaitRepository extends JpaRepository<LigneFraisForfait, Long> {
    List<LigneFraisForfait> findByFicheFraisId(Long ficheFraisId);
    List<LigneFraisForfait> findByVisiteurId(Long visiteurId);
    List<LigneFraisForfait> findByMois(String mois);
}


