package slam.itis.NoteDeFrais.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import slam.itis.NoteDeFrais.model.LigneFraisHorsForfait;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LigneFraisHorsForfaitRepository extends JpaRepository<LigneFraisHorsForfait, Long> {
    // Trouver les lignes hors forfait par fiche de frais
    List<LigneFraisHorsForfait> findByFicheFraisId(Long ficheFraisId);

    // Trouver les lignes hors forfait par date
    List<LigneFraisHorsForfait> findByDate(LocalDate date);

    // Trouver les lignes hors forfait avec un montant supérieur à une valeur
    List<LigneFraisHorsForfait> findByMontantGreaterThan(Double montant);

    // Trouver les lignes hors forfait contenant un mot-clé dans le libellé
    List<LigneFraisHorsForfait> findByLibelleContaining(String keyword);
}
