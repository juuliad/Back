package slam.itis.NoteDeFrais.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import slam.itis.NoteDeFrais.model.FraisForfait;

@Repository
public interface FraisForfaitRepository extends JpaRepository<FraisForfait, Long> {
    // Exemple : trouver un frais forfait par libellé
    FraisForfait findByLibelle(String libelle);
}
