package slam.itis.NoteDeFrais.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slam.itis.NoteDeFrais.model.LigneFraisHorsForfait;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LigneFraisHorsForfaitRepository extends JpaRepository<LigneFraisHorsForfait, Long> {
    List<LigneFraisHorsForfait> findByFicheFraisId(Long ficheFraisId);
    List<LigneFraisHorsForfait> findByDate(LocalDate date);
    List<LigneFraisHorsForfait> findByMontantGreaterThan(Double montant);
    List<LigneFraisHorsForfait> findByLibelleContaining(String keyword);
}
