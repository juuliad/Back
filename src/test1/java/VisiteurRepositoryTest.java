import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import slam.itis.notedefrais.Repository.VisiteurRepository;
import slam.itis.notedefrais.model.Visiteur;

@SpringBootTest(properties = "Spring.Config.name=application-test")
class VisiteurRepositoryTest {

    @Autowired
    private VisiteurRepository visiteurRepository;

    @Test
    void testFindByMdp() {
        // Test un mot de passe valide
        String validPassword = "ValidPass123";
        
        // Création d'un visiteur avec uniquement les champs nécessaires
        Visiteur visiteurValid = new Visiteur("valid@example.com", validPassword);
        visiteurRepository.save(visiteurValid);

        // Vérifier que la méthode findByMdp trouve le visiteur avec le mot de passe valide
        assertTrue(visiteurRepository.findByMdp(validPassword) != null, 
            "Le mot de passe valide doit correspondre à un visiteur");

        // Test un mot de passe trop court
        String shortPassword = "short";
        Visiteur visiteurShort = new Visiteur("short@example.com", shortPassword);
        visiteurRepository.save(visiteurShort);

        // Vérifier que la méthode findByMdp retourne null pour un mot de passe trop court
        assertNull(visiteurRepository.findByMdp(shortPassword), 
            "Le mot de passe trop court ne doit pas correspondre à un visiteur");

        // Test un mot de passe trop long
        String longPassword = "ThisIsAReallyLongPassword123";
        Visiteur visiteurLong = new Visiteur("long@example.com", longPassword);
        visiteurRepository.save(visiteurLong);

        // Vérifier que la méthode findByMdp trouve le visiteur avec un mot de passe long
        assertTrue(visiteurRepository.findByMdp(longPassword) != null, 
            "Le mot de passe long doit correspondre à un visiteur");
    }
}