package test1.java;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import slam.itis.NoteDeFrais.model.Visiteur;
import slam.itis.NoteDeFrais.service.VisiteurService;

@SpringBootTest
class VisiteurServiceTest {

    @Autowired
    private VisiteurService visiteurService; // Injection correcte de Spring

    @Test
    void testIsValidPasswordLength() {
        // Test un mot de passe valide
        String validPassword = "ValidPass123";
        Visiteur visiteurValid = visiteurService.getVisiteurByMdp(validPassword);
        assertNotNull(visiteurValid, "Le mot de passe valide doit correspondre à un visiteur");

        // Test un mot de passe trop court
        String shortPassword = "short";
        Visiteur visiteurShort = visiteurService.getVisiteurByMdp(shortPassword);
        assertNull(visiteurShort, "Le mot de passe trop court ne doit pas être trouvé");

        // Test un mot de passe trop long
        String longPassword = "ThisIsAReallyLongPassword123";
        Visiteur visiteurLong = visiteurService.getVisiteurByMdp(longPassword);
        assertNotNull(visiteurLong, "Le mot de passe long doit correspondre à un visiteur");
    }
}
