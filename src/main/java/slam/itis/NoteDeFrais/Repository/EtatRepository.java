package slam.itis.NoteDeFrais.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import slam.itis.NoteDeFrais.model.Etat;

@Repository
public interface EtatRepository extends JpaRepository<Etat, Long> {
    // Exemple : trouver un état par libellé
    Etat findByLibelle(String libelle);
}
