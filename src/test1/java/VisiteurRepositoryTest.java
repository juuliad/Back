package test1.java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import slam.itis.NoteDeFrais.Repository.VisiteurRepository;
import slam.itis.NoteDeFrais.model.Visiteur;

@SpringBootTest(properties="Spring.Config.name=application-test")
class VisiteurRepositoryTest {
    
    @Autowired
    private VisiteurRepository visiteurRepository;

    @Test
    void testFindByMdp() {
        // Test un mot de passe valide
        String validPassword = "ValidPass123";
        
        // Utilisation du constructeur complet avec tous les paramètres nécessaires
        Visiteur visiteurValid = new Visiteur("NomValid", "PrenomValid", "AdresseValid", "VilleValid", "12345", LocalDate.now(), "valid@example.com", validPassword);
        visiteurRepository.save(visiteurValid);

        // Vérifier que la méthode findByMdp trouve le visiteur avec le mot de passe valide
        assertTrue(visiteurRepository.findByMdp(validPassword) != null, 
            "Le mot de passe valide doit correspondre à un visiteur");

        // Test un mot de passe trop court
        String shortPassword = "short";
        Visiteur visiteurShort = new Visiteur("NomShort", "PrenomShort", "AdresseShort", "VilleShort", "54321", LocalDate.now(), "short@example.com", shortPassword);
        visiteurRepository.save(visiteurShort);

        // Vérifier que la méthode findByMdp retourne null pour un mot de passe trop court
        assertNull(visiteurRepository.findByMdp(shortPassword), 
            "Le mot de passe trop court ne doit pas correspondre à un visiteur");

        // Test un mot de passe trop long
        String longPassword = "ThisIsAReallyLongPassword123";
        Visiteur visiteurLong = new Visiteur("NomLong", "PrenomLong", "AdresseLong", "VilleLong", "67890", LocalDate.now(), "long@example.com", longPassword);
        visiteurRepository.save(visiteurLong);

        // Vérifier que la méthode findByMdp trouve le visiteur avec un mot de passe long
        assertTrue(visiteurRepository.findByMdp(longPassword) != null, 
            "Le mot de passe long doit correspondre à un visiteur");
    }
}